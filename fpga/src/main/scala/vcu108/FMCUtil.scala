package chipyard.fpga.vcu108

import scala.collection.immutable.HashMap

// TODO: was typed by hand, so this needs a once-over before it can be considered trustworthy

object FMCMap {
    // Take an FMC pin name and return the VCU108 package pin, J2 VITA 57.1 FMC HPC1 Connections
    // See https://www.xilinx.com/content/dam/xilinx/support/documentation/boards_and_kits/vcu108/ug1066-vcu108-eval-bd.pdf
    // Pages 90-
    // Omitted pins are not connected to a GPIO
    def apply(fmcPin: String): String = HashMap(
        "A2"->"AG4",
        "A3"->"AG3",
        "A6"->"AF2",
        "A7"->"AF1",
        "A10"->"AE4",
        "A11"->"AE3",
        "A14"->"AD2",
        "A15"->"AD1",
        "A18"->"AC4",
        "A19"->"AC3",
        "A22"->"AM7",
        "A23"->"AM6",
        "A26"->"AK7",
        "A27"->"AK6",
        "A30"->"AH7",
        "A31"->"AH6",
        "A34"->"AF7",
        "A35"->"AF6",
        "A38"->"AD7",
        "A39"->"AD6",
        "B4"->"W4",
        "B5"->"W3",
        "B8"->"Y2",
        "B9"->"Y1",
        "B12"->"AA4",
        "B13"->"AA3",
        "B16"->"AB2",
        "B17"->"AB1",
        "B20"->"AA9",
        "B21"->"AA8",
        "B24"->"T7",
        "B25"->"T6",
        "B28"->"V7",
        "B29"->"V6",
        "B32"->"Y7",
        "B33"->"Y6",
        "B36"->"AB7",
        "B37"->"AB6",
        "C10" -> "P37",
        "C11" -> "N37",
        "C14" -> "N32",
        "C15" -> "M32",
        "C18" -> "L33",
        "C19" -> "K33",
        "C22" -> "AL32",
        "C23" -> "AM32",
        "C26" -> "AP35",
        "C27" -> "AR35",
        "D1"  -> "AP23",
        "D8"  -> "P35",
        "D9"  -> "P36",
        "D11" -> "N38",
        "D12" -> "M38",
        "D14" -> "M36",
        "D15" -> "L36",
        "D17" -> "T30",
        "D18" -> "T31",
        "D20" -> "AJ32",
        "D21" -> "AK32",
        "D23" -> "AN33",
        "D24" -> "AP33",
        "D26" -> "AL29",
        "D27" -> "AM29",
        "F1"  -> "AU24",
        "G2"  -> "AK34",
        "G3"  -> "AL34",
        "G6"  -> "T33",
        "G7"  -> "R33",
        "G9"  -> "N34",
        "G10" -> "N35",
        "G12" -> "M35",
        "G13" -> "L35",
        "G15" -> "R31",
        "G16" -> "P31",
        "G18" -> "U31",
        "G19" -> "U32",
        "G21" -> "AR37",
        "G22" -> "AT37",
        "G24" -> "AL30",
        "G25" -> "AL31",
        "G27" -> "AP36",
        "G28" -> "AP37",
        "G30" -> "AP38",
        "G31" -> "AR38",
        "G33" -> "AN34",
        "G34" -> "AN35",
        "G36" -> "AG32",
        "G37" -> "AG33",
        "H2"  -> "BD23",
        "H4"  -> "R32",
        "H5"  -> "P32",
        "H7"  -> "N33",
        "H8"  -> "M33",
        "H10" -> "M37",
        "H11" -> "L38",
        "H13" -> "L34",
        "H14" -> "K34",
        "H16" -> "Y31",
        "H17" -> "W31",
        "H19" -> "T34",
        "H20" -> "T35",
        "H22" -> "AT39",
        "H23" -> "AT40",
        "H25" -> "AT35",
        "H26" -> "AT36",
        "H28" -> "AM36",
        "H29" -> "AN36",
        "H31" -> "AL35",
        "H32" -> "AL36",
        "H34" -> "AJ30",
        "H35" -> "AJ31",
        "H37" -> "AG31",
        "H38" -> "AH31"
    )(fmcPin)
}

object FMCPMap {
    // Take an FMC pin name and return the VCU108 package pin,J22 VITA 57.1 FMC HPC0 Connections
    // See https://www.xilinx.com/content/dam/xilinx/support/documentation/boards_and_kits/vcu108/ug1066-vcu108-eval-bd.pdf
    // Pages 85-
    // Omitted pins are not connected to a GPIO
    def apply(fmcpPin: String): String = HashMap(
        "A2"->"H2",
        "A3"->"H1",
        "A6"->"F2",
        "A7"->"F1",
        "A10"->"D2",
        "A11"->"D1",
        "A14"->"T2",
        "A15"->"T1",
        "A18"->"R4",
        "A19"->"R3",
        "A22"->"F7",
        "A23"->"F6",
        "A26"->"E5",
        "A27"->"E4",
        "A30"->"C5",
        "A31"->"C4",
        "A34"->"L5",
        "A35"->"L4",
        "A38"->"K7",
        "A39"->"K6",
        "C2"->"G5",
        "C3"->"G4",
        "C6"->"K2",
        "C7"->"K1",
        "C10"->"BE10",
        "C11"->"BE9",
        "C14"->"BE14",
        "C15"->"BF14",
        "C18"->"BB13",
        "C19"->"BB12",
        "C22"->"AP13",
        "C23"->"AR13",
        "C26"->"AN14",
        "C27"->"AN13",
        "D24"->"AT15",
        "D27"->"AM14",
        "E2"->"T14",
        "E3"->"R13",
        "E6"->"AA12",
        "E7"->"Y12",
        "E9"->"AA14",
        "E10"->"Y14",
        "E12"->"W14",
        "E13"->"V14",
        "E15"->"V16",
        "E16"->"U16",
        "E18"->"R11",
        "E19"->"P11",
        "G2"->"AU14",
        "G3"->"AU13",
        "G6"->"AY9",
        "G7"->"BA9",
        "G9"->"BD8",
        "G10"->"BD7",
        "G12"->"BF10",
        "G13"->"BF9",
        "G15"->"BE15",
        "G16"->"BF15",
        "G18"->"AY8",
        "G19"->"AY7",
        "G21"->"AY15",
        "G22"->"AY14",
        "G24"->"AN15",
        "G25"->"AP15",
        "G27"->"AM13",
        "G28"->"AM12",
        "G30"->"AK14",
        "G31"->"AK13",
        "G33"->"AP12",
        "G34"->"AR12",
        "G36"->"AU16",
        "G37"->"AV16",
        "H37"->"AU11",
        "J6"->"K11",
        "J7"->"J11",
        "J9"->"R12",
        "J10"->"P12",
        "J12"->"M11",
        "J13"->"L11",
        "J15"->"K14",
        "J16"->"K13",
        "J18"->"L14",
        "J19"->"L13",
        "J21"->"M15",
        "J22"->"L15",
        "B4"->"W4",
        "B5"->"W3",
        "B8"->"Y2",
        "B9"->"Y1",
        "B12"->"M2",
        "B13"->"M1",
        "B16"->"P2",
        "B17"->"P1",
        "B20"->"N9",
        "B21"->"N8",
        "B24"->"T7",
        "B25"->"T6",
        "B28"->"V7",
        "B29"->"V6",
        "B32"->"H7",
        "B33"->"H6",
        "B36"->"J5",
        "B37"->"J4",
        "D4"->"R9",
        "D5"->"R8",
        "D8"->"BC10",
        "D9"->"BD10",
        "D11"->"BF12",
        "D12"->"BF11",
        "D14"->"BD13",
        "D15"->"BE13",
        "D17"->"BA14",
        "D18"->"BB14",
        "D20"->"AV14",
        "D21"->"AV13",
        "D23"->"AT16",
        "D26"->"AL14",
        "F4"->"N14",
        "F5"->"N13",
        "F7"->"AA13",
        "F8"->"Y13",
        "F10"->"W12",
        "F11"->"V12",
        "F13"->"V15",
        "F14"->"U15",
        "F16"->"V13",
        "F17"->"U12",
        "F19"->"R14",
        "F20"->"P14",
        "H2"->"AL19",
        "H4"->"BB9",
        "H5"->"BB8",
        "H7"->"BA7",
        "H8"->"BB7",
        "H10"->"BE8",
        "H11"->"BE7",
        "H13"->"BD12",
        "H14"->"BE12",
        "H16"->"BC11",
        "H17"->"BD11",
        "H19"->"AV9",
        "H20"->"AV8",
        "H22"->"AV15",
        "H23"->"AW15",
        "H25"->"AN16",
        "H26"->"AP16",
        "H28"->"AK15",
        "H29"->"AL15",
        "H31"->"AJ13",
        "H32"->"AJ12",
        "H34"->"AK12",
        "H35"->"AL12",
        "H38"->"AV11",
        "K7"->"T16",
        "K8"->"T15",
        "K10"->"P15",
        "K11"->"N15",
        "K13"->"K12",
        "K14"->"J12",
        "K16"->"U13",
        "K17"->"T13",
        "K19"->"M13",
        "K20"->"M12",
        "K22"->"U11",
        "K23"->"T11"
    )(fmcpPin)
}

