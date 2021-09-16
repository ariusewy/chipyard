package chipyard.fpga.vcu108

import chipyard.DefaultClockFrequencyKey
import freechips.rocketchip.config.Config
import freechips.rocketchip.devices.tilelink.BootROMLocated
import freechips.rocketchip.diplomacy.DTSTimebase
import freechips.rocketchip.subsystem.ExtMem
import sifive.blocks.devices.spi.{PeripherySPIKey, SPIParams}
import sifive.blocks.devices.uart.{PeripheryUARTKey, UARTParams}
import sifive.fpgashells.shell.xilinx.{VCU108DDRSize, VCU108ShellPMOD}
import testchipip.SerialTLKey

import scala.sys.process._

class WithDefaultPeripherals extends Config((site, here, up) => {
  case PeripheryUARTKey => List(UARTParams(address = BigInt(0x64000000L)))
  case PeripherySPIKey => List(SPIParams(rAddress = BigInt(0x64001000L)))
  case VCU108ShellPMOD => "SDIO"
})

class WithSystemModifications extends Config((site, here, up) => {
  case DTSTimebase => BigInt((1e6).toLong)
  case BootROMLocated(x) => up(BootROMLocated(x), site).map { p =>
    // invoke makefile for sdboot
    val freqMHz = (site(DefaultClockFrequencyKey) * 1e6).toLong
    val make = s"make -C fpga/src/main/resources/vcu118/sdboot PBUS_CLK=${freqMHz} bin"
    require (make.! == 0, "Failed to build bootrom")
    p.copy(hang = 0x10000, contentFileName = s"./fpga/src/main/resources/vcu118/sdboot/build/sdboot.bin")
  }
  case ExtMem => up(ExtMem, site).map(x => x.copy(master = x.master.copy(size = site(VCU108DDRSize)))) // set extmem to DDR size
  case SerialTLKey => None // remove serialized tl port
})

// DOC include start: AbstractVCU108 and Rocket
class WithVCU108Tweaks extends Config(
  // harness binders
  new WithUART ++
  new WithSPISDCard ++
  new WithDDRMem ++
  // io binders
  new WithUARTIOPassthrough ++
  new WithSPIIOPassthrough ++
  new WithTLIOPassthrough ++
  // other configuration
  new WithDefaultPeripherals ++
  new chipyard.config.WithTLBackingMemory ++ // use TL backing memory
  new WithSystemModifications ++ // setup busses, use sdboot bootrom, setup ext. mem. size
  new chipyard.config.WithNoDebug ++ // remove debug module
  new freechips.rocketchip.subsystem.WithoutTLMonitors ++
  new freechips.rocketchip.subsystem.WithNMemoryChannels(1) ++
  new WithFPGAFrequency(100) // default 100MHz freq
)

class RocketVCU108Config extends Config(
  new WithVCU108Tweaks ++
  new chipyard.RocketConfig)
// DOC include end: AbstractVCU108 and Rocket

class BoomVCU108Config extends Config(
  new WithFPGAFrequency(50) ++
  new WithVCU108Tweaks ++
  new chipyard.LargeBoomConfig)

class WithFPGAFrequency(fMHz: Double) extends Config(
  new chipyard.config.WithPeripheryBusFrequency(fMHz) ++ // assumes using PBUS as default freq.
  new chipyard.config.WithMemoryBusFrequency(fMHz)
)

class WithFPGAFreq25MHz extends WithFPGAFrequency(25)

class WithFPGAFreq50MHz extends WithFPGAFrequency(50)

class WithFPGAFreq75MHz extends WithFPGAFrequency(75)

class WithFPGAFreq100MHz extends WithFPGAFrequency(100)
