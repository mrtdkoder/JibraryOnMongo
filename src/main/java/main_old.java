import DAO.MongoDBClient;
import Models.Member;
import Models.MemberRepostory;

import java.util.Date;

public class main_old {
    public static void main(String[] args) {
        MongoDBClient mongo = new MongoDBClient();
        MemberRepostory people = new MemberRepostory(true);
        /*people.add(new Member(0,"Murat nc",
                                "mmx@mmx.com",
                                "07788996655",
                                "22 somewhere",
                                new Date()));
        people.add(new Member(0,"suat nc",
                "ssx@mmx.com",
                "07788996655",
                "22 somewhere",
                new Date()));
        people.add(new Member(0,"fuat nc",
                "ffx@mmx.com",
                "07788996655",
                "22 somewhere",
                new Date()));

        System.out.printf("%s", new Date());*/
        /*String dateString = "2022-12-31";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dateString);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*System.out.println("people list is being loaded");
         List<Person> peopleList = mongo.loadList("Person", Person.class);
         peopleList.forEach(p->{
             //System.out.println("delete = " + mongo.delete(p, Person.class, "Person", "personId", p.personId));
             mongo.removePerson(p);
         });
        System.out.println("people list is loaded");
//      System.out.println(peopleList.size());
//        peopleList.forEach(p->{people.add(p);});

        //people.getAll().forEach(Person::generateId);
        people.getAll().forEach(System.out::println);
        Person fuat = people.getAll().stream().filter(p->p.email.equals("mmx@mmx.com")).findFirst().get();
        mongo.updatePerson(fuat);
        fuat.address = "22 nowhere " + LocalDate.now().toString();

        people.update(fuat.personId, fuat);
        mongo.insertPerson(fuat);
        //mongo.removePerson(fuat);

       people.getAll().forEach(System.out::println);

       Person suat = people.getPersonByName("suat nc");
       suat.phone = "05323233232";
       people.update(suat.personId, suat);

        people.getAll().forEach(System.out::println);
        System.out.println("----------------------");

        people.searchAllToList("su").forEach(System.out::println);



        System.out.println("mongo.insert(suat, Person.class) = " + mongo.insert(suat, Person.class, "Person"));
        suat.phone = "aaaaaaaaaaaa";
        System.out.println("mongo.update(suat, Person.class, \"personId\", suat.personId) = " + mongo.update(suat, Person.class, "Person", "personId", suat.personId));
        System.out.println("mongo.delete = " + mongo.delete(suat, Person.class, "Person", "personId", suat.personId));
*/
        /*for(int i = 0; i < 10; i++) {
            mongo.insertPerson(new Person(LocalDateTime.now().getMinute() + 20+i, (i*i) + ".murat", "mm"+i+"@mm.com",
                                    i + "07788996655", i + ". sokak", new Date()));
        }*/


        /*Gson gson = new Gson();
        System.out.println("gson.toJson(people.getAll()) = " + gson.toJson(people.getAll()));

        MongoDBClient mdb = new MongoDBClient();
        //mdb.createCollection("Books");*/
    }
}
