package javaIntermediate.enums;

public enum Day {

    
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    


    /*
    at compile time:
    public class final Day extends java.lang.Enum<Day> {
        public static final Day Sunday = new Day("SUNDAY", 0);
        public static final Day Sunday = new Day("MONDAY", 1);
        public static final Day Sunday = new Day("TUESDAY", 2);
        public static final Day Sunday = new Day("WEDNESDAY", 3);
        public static final Day Sunday = new Day("THURSDAY", 4);
        public static final Day Sunday = new Day("FRIDAY", 5);
        public static final Day Sunday = new Day("SATURDAY", 6);

        private static final Day[] VALUES = {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
        
        private Day (String name, int ordinal) {
            super(name, ordinal);
        }

        public static Day[] values() {
            return ALUES.clone();
        }

        public static Day valueOf(String name){
            for(Day day : VALUES) {
                if(day.name().equals(name)) {
                    return day;
                }
            }
            throw new IllegalArgumentException("No enum content " + name);
        }

    }
    */ 
}
