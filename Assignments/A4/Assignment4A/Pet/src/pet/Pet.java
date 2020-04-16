
package pet;

/**
 * A class of a pet.
 * 
 * @author Alex Vasil
 */
public abstract class Pet {
    
    private String name;
    private int age;
    private final char gender;

    public Pet(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public abstract void talk();
    
    /**
     * Increments the age of the pet by 1.
     * 
     * @return the new age added by 1.
     */
    protected int nextAge() {
        age = this.age++;
        return this.age++;
    }
    
    @Override
    public String toString() {
        char strGender = Character.toUpperCase(gender);
        return "I'm " + name + ", a " + age + " year old " + 
                ((strGender == 'M') ? "male" : "female") + " pet";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final Pet other = (Pet) obj;
        if (this.age != other.age)
            return false;
        if (this.gender != other.gender)
            return false;
        if (!this.name.equals(other.name))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }
    
}
