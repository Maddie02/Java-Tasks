package task;

public enum Region {
    SOFIA, BURGAS, VARNA, PLOVDIV, RUSE, GABROVO, VIDIN, VRATSA;

    public String getPrefix() {
        switch(this) {
            case SOFIA: return "CB";
            case BURGAS: return "A";
            case VARNA: return "B";
            case VIDIN: return "BH";
            case VRATSA: return "BP";
            case GABROVO: return "EB";
            case PLOVDIV: return "PB";
            case RUSE: return "P";
        }
        return null;
    }
}
