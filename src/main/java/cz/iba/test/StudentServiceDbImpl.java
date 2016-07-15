package cz.iba.test;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class StudentServiceDbImpl extends HibernateDaoSupport implements StudentService {

    public StudentServiceDbImpl() {
    }

    public void init(){
        Student angelina = new Student();
        angelina.setFirstName("Angelina");
        angelina.setLastName("Jolie");
        angelina.setDateOfBirth(new Date());
        angelina.setSex(Sex.FEMALE);

        Student john = new Student();
        john.setFirstName("John");
        john.setLastName("Smith");
        john.setDateOfBirth(new Date());
        john.setSex(Sex.MALE);

        getHibernateTemplate().save(angelina);
        getHibernateTemplate().save(john);
    }

    @Override
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate hibernateTemplate =  super.createHibernateTemplate(sessionFactory);
        hibernateTemplate.setCheckWriteOperations(false);
        return hibernateTemplate;
    }

    @Override
    public List<Student> findAll() {
        return getHibernateTemplate().loadAll(Student.class);
    }

    @Override
    public Student getById(int id) {
        return getHibernateTemplate().get(Student.class, id);
    }

    @Override
    @Transactional
    public void add(Student student) {
        getHibernateTemplate().save(student);
    }

    @Override
    @Transactional
    public void addAll(Collection<Student> students) {
        students.forEach(getHibernateTemplate()::save);
    }

    @Override
    @Transactional
    public void remove(Student student) {
        getHibernateTemplate().delete(student);
    }

    @Override
    @Transactional
    public void remove(int id) {
        remove(getById(id));
    }

    @Override
    @Transactional
    public void removeAll(Collection<Student> students) {
        getHibernateTemplate().deleteAll(students);
    }

    @Override
    @Transactional
    public void update(Student student) {
        getHibernateTemplate().saveOrUpdate(student);
    }

    @Override
    @Transactional
    public void clear() {
        removeAll(findAll());
    }
}
