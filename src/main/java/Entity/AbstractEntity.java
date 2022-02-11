package Entity;

import java.io.Serializable;

public abstract class AbstractEntity implements EntityInterface, Serializable
{
    abstract public int getId();
}
