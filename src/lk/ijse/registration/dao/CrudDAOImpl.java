package lk.ijse.registration.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudDAOImpl<T,ID> implements CrudDAO<T,ID>{


    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> entity;

    public CrudDAOImpl(){
        entity = (Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public void save(T entity) throws Exception {
        getEntityManager().persist(entity);
    }

    @Override
    public void delete(ID id) throws Exception {
        T t = getEntityManager().find(entity, id);
        getEntityManager().remove(t);
    }


    @Override
    public void update(T entity) throws Exception {
getEntityManager().persist(entity);
    }

    @Override
    public List<T> getAll() throws Exception {
        return getEntityManager().createQuery("FROM "+ entity.getName()).getResultList();
    }

    @Override
    public T find(ID id) throws Exception {
       return getEntityManager().find(entity, id);

    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

//    @Override
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
}