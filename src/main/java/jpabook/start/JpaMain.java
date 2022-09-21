package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Member member = createMember("id33", "laone");
            member.setUsername("spica");
            mergeMember(member);

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    static Member createMember(String id, String username){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member member = new Member();
        try{
            tx.begin();
            member.setId(id);
            member.setUsername(username);
            em.persist(member);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        return member;
    }
    static void mergeMember(Member member){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Member mergeMember = em.merge(member);

            System.out.println("==============================");
            System.out.println("member.getUsername() = " + member.getUsername());
            System.out.println("mergeMember.get = " + mergeMember.getUsername());
            System.out.println("em.contains(member) = " + em.contains(member));
            System.out.println("em.contains(member) = " + em.contains(mergeMember));
            System.out.println("==============================");

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }
}
