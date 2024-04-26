import java.util.Date;

//trieda uzivatel
public class User {
    //id - int
    // meno, priezvisko,email,mesto,stat,telefon, heslo - String
    // datumNarodenia,poslednePrihlasenie - DATE
    // pohlavie - M|F

    private String meno="";
    public String priezvisko="";
    public String email="";
    public String mesto="";
    public String stat="";
    public String telefon="";
    public String heslo="";
    public int id;
    public char gender;
    public Date datumNarodenia;
    public Date datumPoslednehoPrihlasenia=null;

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

    public StatusCode code;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDatumNarodenia() {
        return datumNarodenia;
    }

    public void setDatumNarodenia(Date datumNarodenia) {
        this.datumNarodenia = datumNarodenia;
    }

    public Date getDatumPoslednehoPrihlasenia() {
        return datumPoslednehoPrihlasenia;
    }

    public void setDatumPoslednehoPrihlasenia(Date datumPoslednehoPrihlasenia) {
        this.datumPoslednehoPrihlasenia = datumPoslednehoPrihlasenia;
    }
//vytvorit potrebne parametre pre uzivatela a vygenerovat gettere a settre

    public String prezentujSa(){
        return this.meno+" "+this.getPriezvisko()+" "+this.mesto+" "+this.stat;//+this.datumPoslednehoPrihlasenia.toString();
        //vrati String meno, priezvisko, email,datum narodenia,mesta,stat, telefon, posledne prihlasenie
        //POZOR vrati, nie vypisuje.
    }

}
