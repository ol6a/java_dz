package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names="-c", description="Contact count")
    public int count;
    @Parameter (names="-f", description="Target file")
    public String file;
    @Parameter (names="-d", description="Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander=new JCommander(generator);
        try{jCommander.parse(args);
        } catch(ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts= generateContacts(count);
        if(format.equals("xml")){
            saveAsXml(contacts, new File(file));
        } else{
            System.out.println("Unrecognized format");
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream=new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml=xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }


    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts =new ArrayList<ContactData>();
        for (int i=0; i<count; i++){
            File photo = new File("src/test/resources/kartinka.png");
            contacts.add(new ContactData().withFirstname("Арина").withLastname("Розина")
                    .withAddress(String.format("г. Москва, ул. Дружбы, %s-%s",i,i))
                    .withHomePhone(String.format("%s%s-%s%s-%s%s",i,i,i,i,i,i))
                    .withMobilePhone(String.format("+7911%s%s%s%s%s%s%s",i,i,i+1,i,i,i,i))
                    .withWorkPhone(String.format("%s%s-%s%s-%s%s",i,i,i,i,i+2,i))
                    .withEmail(String.format("rr%s@moi-uni.ru",i))
                    .withEmail2(String.format("era%s@moi-uni.ru",i))
                    .withEmail3(String.format("oplata%s@moi-uni.ru",i))
                    .withPhoto(photo));
        }
        return contacts;
    }
}
