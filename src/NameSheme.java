import java.util.StringTokenizer;

public class NameSheme {

    String type;
    String month;
    String id;
    String number;
    String fileextension;

    public NameSheme(String name){

        StringTokenizer tok = new StringTokenizer(name, "-");
        this.type = tok.nextToken();
        this.month = tok.nextToken();
        this.id = tok.nextToken();
        String side = tok.nextToken();
        StringTokenizer sidetok = new StringTokenizer(side, ".");
        number = sidetok.nextToken();
        fileextension = sidetok.nextToken();
    }
    public String getType(){ return type; }
    public String getMonth(){ return month; }
    public String getId(){ return id; }
    public String getNumber() { return number;}
    public String getFileextension() { return fileextension; }

    public boolean equals(NameSheme ns){

        if(ns.getFileextension().equals(this.fileextension) &&
            ns.getId().equals(this.id) && ns.getMonth().equals(this.month) &&
                ns.getNumber().equals(this.number) && ns.getType().equals(this.type)){
            return true;
        }
        return false;
    }
    public boolean compareID(String id){

        if(id.equals(this.id)) return true;
        return false;
    }

}
