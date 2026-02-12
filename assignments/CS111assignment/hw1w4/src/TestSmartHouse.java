// Wirakorn Thanabat  
// 6809617415  

public class TestSmartHouse {
    public static void main(String[] args) {
        SmartHouse sh1 = new SmartHouse ();
        sh1.printHouseAppliancesStatus();
        System.out.println("----------------");
        sh1.turnOnAirConditioner() ;// เปิดเครื่องปรับอากาศ
        sh1.setLockStatusOfGate("unlocked") ; // เปิดประตูหน้า
        sh1. printHouseAppliancesStatus();
        System.out.println("----------------");
        sh1.turnOffAirConditioner() ; //ปิดเครื่องปรับอากาศ
        sh1.setLockStatusOfGate("lock") ; //ปิดประตูหน้า
        sh1.printHouseAppliancesStatus();
    }

    public static class SmartHouse {
        boolean airConditionOnStatus;
        boolean frontGateOnStatus;
        
        public SmartHouse() {}
        public void printHouseAppliancesStatus() {
            System.out.printf("Air Conditioner is %s\n", (airConditionOnStatus) ? "ON" : "OFF");
            System.out.printf("Front Gate is %s\n", (frontGateOnStatus) ? "OPEN" : "CLOSED");
        }

        public void turnOnAirConditioner() {
            airConditionOnStatus = true;
        }
        public void turnOffAirConditioner() {
            airConditionOnStatus = false;
        }

        public void setLockStatusOfGate(String operation) {
            switch (operation) {
                case "unlocked":
                    frontGateOnStatus = true;
                    break;
                case "lock":
                    frontGateOnStatus = false;
                default:
                    break;
            }
        }
    }
}