package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;

/**
 * Classe permettant d'insérer des données dans l'application.
 */
@Service
@Transactional
public class InitData implements ApplicationListener<ApplicationReadyEvent> {

    private EntityManager entityManager;

    public InitData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        insertTestData();
    }

    private void insertTestData() {
        Article a1 = createArticle("Les conserves de viande de licorne", 22.98, "https://static.hitek.fr/img/actualite/2016/08/26/41gn6tpvqtl.jpg", 1);
        Article a2 = createArticle("Wenger Couteau suisse géant", 46.39, "https://static.hitek.fr/img/actualite/2016/08/26/61abqa-gt8s-sx522.jpg", 40);
        Article a3 = createArticle("PAPIER TOILETTE DONALD TRUMP", 4.99, "https://static.hitek.fr/img/actualite/2016/08/26/61cb4xnrbol-sx522.jpg", 100);
        Article a4 = createArticle("Grattoir pour Chat en Forme de Platine de DJ", 23.14, "https://static.hitek.fr/img/actualite/2016/08/26/61grir, 20ay9-l-sx522.jpg", 100);
        Article a5 = createArticle("Jay nothing", 2, "https://static.hitek.fr/img/actualite/2016/08/26/61vu-jqjygl-sy679.jpg", 0);
        Article a6 = createArticle("UN AFFINEUR DE VISAGE", 52, "https://static.hitek.fr/img/actualite/2016/08/26/w_41r-1yapf5l.jpg", 20);

        Client c1 = createClient("John", "Doe", LocalDate.of(1996, 4, 30));
        Client c2 = createClient("Mickel", "Gerrin", LocalDate.of(1990, 1, 2));
    }

    private Client createClient(String prenom, String nom, LocalDate dateNaissance) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setDateNaissance(dateNaissance);
        entityManager.persist(client);
        return client;
    }

    private Article createArticle(String libelle, double prix, String imageUrl, Integer stock) {
        Article a1 = new Article();
        a1.setLibelle(libelle);
        a1.setPrix(prix);
        a1.setImageUrl(imageUrl);
        a1.setStock(stock);
        entityManager.persist(a1);
        return a1;
    }

}
