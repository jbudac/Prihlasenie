import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
    //list uzivatelov
    public List<User> userList=new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    //metoda pre prihlasenie uzivatela
    public User login(String email, String heslo){
        User prihlaseny=null;
        for(User user : userList){
            if(user.getEmail().equals(email) && user.getHeslo().equals(heslo)){
                user.setDatumPoslednehoPrihlasenia(new Date());
                prihlaseny=user;
            }
        }
        //ak najde uzivatela podla mena a heslo tak ho vrati a
        // nastavi hodnodut datumPrihlasenia na aktualny datum
        return prihlaseny;
    }

    //metoda pre naictanie dat z pola ktore je definovana v Run triede.
    public void parseArray(String [][] csvArray){
        for (int i=0;i<csvArray.length;i++){
            //citam novy riadok
            User user=new User();
            String [] riadok=csvArray[i];
            for (int j=0;j<riadok.length;j++){
               String hodnota=riadok[j];
                //id,meno,priezvisko,email,mesto,stat,telefon,datumNarodenie,heslo,pohlavie,datumPrihlasenia
                switch(j){
                    case 0:
                        user.setId(Integer.parseInt(hodnota));
                        break;
                    case 1:
                        user.setMeno(riadok[j]);
                        break;
                    case 2:
                        user.setPriezvisko(riadok[j]);
                        break;
                    case 3:
                        user.setEmail(csvArray[i][j]);
                        break;
                    case 4:
                        user.setMesto(csvArray[i][j]);
                        break;
                    case 5:
                        user.setStat(csvArray[i][j]);
                        break;
                    case 6:
                        user.setTelefon(csvArray[i][j]);
                        break;
                    case 7:
                        try{
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = formatter.parse(csvArray[i][j]);
                            user.setDatumNarodenia(date);
                        }catch(Exception e){
                        }
                        break;
                    case 8:
                        user.setHeslo(csvArray[i][j]);
                        break;
                    case 9:
                        user.setGender(csvArray[i][j].charAt(0));
                        break;
                    case 10:
                        try{
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = formatter.parse(csvArray[i][j]);
                            user.setDatumPoslednehoPrihlasenia(date);
                        }catch(Exception e){
                        }
                        break;

                }
            }
            userList.add(user);
        }
        //oprogramovat nacitanie pola a vlozit objekty uzivatela do userListu
    }

    //metoda pre naictanie suboru, ktory je definovany v files/data.csv.
    public void parseCSV(String filePath){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String [] riadok=line.split(",");
                //oprogramovat nacitanie suboru a vlozit objekty uzivatela do userListu
                //to iste co pri poli, ale zo suboru.
                // citanie dalsieho riadku
                User user=new User();

                this.userList.add(user);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> filterByStatusCode(StatusCode filterCode){
        List<User> filterList=new ArrayList<>();
        for (User user :userList){
            if(user.getCode().equals(filterCode.code)){
                filterList.add(user);
            }
        }
        return filterList;
    }

    public String loadJson(String fileUrl){
        String jsonData="";
        try {
            // URL, ze které chceme načíst JSON data
            //String urlString = "http://example.com/data.json";
            URL url = new URL(fileUrl);

            // Otevření spojení a načtení dat
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

            // Uzavření spojení
            reader.close();
            inputStream.close();

            // Získání JSON dat jako řetězec
            jsonData = jsonStringBuilder.toString();

            // Zpracování JSON dat
            // Zde byste měli použít knihovnu pro zpracování JSON, například org.json.JSONObject
            // nebo com.google.gson.Gson
            // Zde je příklad s org.json.JSONObject:

            // JSONObject jsonObject = new JSONObject(jsonData);
            // ... pracujte s jsonObject dál ...

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
    public void parseJson(String jsonString){
        JSONArray jsonArray = new JSONArray(jsonString);

        // Procházení jednotlivých uživatelů v poli
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userObject = jsonArray.getJSONObject(i);

            // Získání atributů uživatele (id, name, age)
            User user=new User();
            user.setId(userObject.getInt("Index"));
           user.setMeno(userObject.getString("FirstName"));
           user.setPriezvisko(userObject.getString("LastName"));
           user.setHeslo(userObject.getString("Password"));
            user.setEmail(userObject.getString("Email"));
            user.setMesto(userObject.getString("City"));
            user.setStat(userObject.getString("Country"));
            // Zpracování informací o uživateli
            this.userList.add(user);
          //  System.out.println("User " + id + ": " + name + ", Priezvisko: " + age);
        }
    }

    public JSONObject loadJsonFromUrl(String urlString){
        URL url;
        JSONObject jsonFile = null;
        StringBuilder response;
        try{
            url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            jsonFile=new JSONObject(response.toString());
            reader.close();
        }catch(Exception e){

        }

        return jsonFile;
    }

    public List<User> filter(String filterString){
        List<User> filterUserList=new ArrayList<>();
        for(User user: userList){
            if(user.getPriezvisko().indexOf(filterString)>=0 || user.getEmail().indexOf(filterString)>=0){
                filterUserList.add(user);
            }
        }
        return filterUserList;
    }

    public User zrebuj(){
        return this.userList.get((int)(Math.random()*this.userList.size()));
    }

}
