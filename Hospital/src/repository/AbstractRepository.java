package repository;

import domain.UniqueIdentifier;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRepository<T extends UniqueIdentifier<ID>,ID> {
    private Map<ID,T> objects=new HashMap<ID,T>();

    public void addElementValue(T element) throws RuntimeException
    {
        try {
            if (objects.containsKey(element.getID()))
            {
                throw new RuntimeException();
            }
            objects.put(element.getID(), element);
        }catch (RuntimeException e){System.out.println("Already an id like this in the repository");};

    }

    public boolean deleteElementValue(T element)
    {
        if(!objects.containsKey(element.getID()))
            return false;
        objects.remove(element.getID());
        return true;
    }
    public boolean deleteElementValueId(ID id)
    {
        if(!objects.containsKey(id))
            return false;
        objects.remove(id);
        return true;
    }
    public T findById(ID id)
    {
        if(objects.containsKey(id))
            return objects.get(id);
        throw new RuntimeException("There is no element with the id "+id);
    }
    public boolean updateById(ID id,T element)
    {
        if(!objects.containsKey(id))
            return false;
        objects.remove(id);
        objects.put(element.getID(), element);
        //qobjects.values().add(element);
        return true;
    }
    public boolean existCheck(ID id)
    {
        if(this.objects.containsKey(id))
            return true;
        return false;
    }
    public Map<ID,T> seeObjects()
    {
        return objects;
    }
}
