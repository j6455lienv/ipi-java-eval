package com.ipiecoles.java.javaeval;

import com.ipiecoles.java.javaeval.model.Employe;
import com.ipiecoles.java.javaeval.model.Manager;
import com.ipiecoles.java.javaeval.model.Technicien;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        Connection connexion = initConnection();
        Statement statement = connexion.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Employe LIMIT 10");
        while ( resultSet.next() ) {
            print(resultSet.getString("nom"));
            print(resultSet.getDate("dateEmbauche"));
        }


//        Technicien t = technicienRepository.findOne(4L);
//        print(t);
//
//        Manager m = managerRepository.findOneWithEquipeById(43L);
//        print(m);
//        m.getEquipe().stream().forEach(MyRunner::print);
//        m.setPrenom(m.getPrenom().toUpperCase());
//        managerRepository.save(m);
//
//        print(employeRepository.count());
//
//        List<Employe> list = employeRepository.findByNomAndPrenom("Adam", "Laura");
//        list.stream().map(Employe::toString).forEach(MyRunner::print);
//
//        list = employeRepository.findByDateEmbaucheBefore(new LocalDate(2012,07,28));
//        list.stream().map(Employe::toString).forEach(MyRunner::print);
//
//        list = employeRepository.findByDateEmbaucheAfter(new LocalDate(2012,07,28));
//        list.stream().map(Employe::toString).forEach(MyRunner::print);
//
//        list = employeRepository.findBySalaireGreaterThanOrderBySalaireDesc(2000.0);
//        list.stream().map(Employe::toString).forEach(MyRunner::print);
//
//        list = employeRepository.findByNomOrPrenomAllIgnoreCase("adam");
//        list.stream().map(Employe::toString).forEach(MyRunner::print);
//
//        PageRequest pageRequest = new PageRequest(0, 5, Sort.Direction.ASC, "matricule");
//
//        Page<Technicien> techs = technicienRepository.findByNomIgnoreCase("adam", pageRequest);
//        while(pageRequest.next()){
//
//            techs.forEach(MyRunner::print);
//        }
//        print("coucou");
//        print("coucou3");
//        techs = technicienRepository.findByNomIgnoreCase("adam", pageRequest.next());
//        techs.forEach(MyRunner::print);
//
//        print(technicienRepository.findByNomOrPrenomAllIgnoreCase("adam").size());
//        print(employeRepository.findByNomOrPrenomAllIgnoreCase("adam").size());

        }

    public java.sql.Connection initConnection(){
        String url = "jdbc:mysql://localhost:3306/entreprise?autoReconnect=true&useSSL=false";
        String user = "root";
        String pwd = "root";

        java.sql.Connection connexion = null;

        try {
            connexion = java.sql.DriverManager.getConnection(url, user, pwd);
        } catch ( java.sql.SQLException e ) {
            //Problème de connexion à la base !
            print(e.getMessage());
        }
        return connexion;
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
