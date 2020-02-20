
package task3;

/**
 * Class of a Author.
 * 
 * @author Alex Vasil
 */
public class Author {
    private String name;
    private String email;
    private String nationality;

    /**
     * Constructor with default values.
     */
    public Author() {
        name = "John Doe";
        email = "johndoe@email.com";
        nationality = "Canadian";
    }

    /**
     * Constructor with set values.
     * 
     * @param name The name of the author.
     * @param email The email of the author.
     * @param nationality The nationality of the author
     */
    public Author(String name, String email, String nationality) {
        this.name = name;
        this.email = email;
        this.nationality = nationality;
    }
    
    /**
     * Deep copy of author.
     * 
     * @param anotherAuthor constructor being copied from.
     */
    public Author(Author anotherAuthor) {
        this.name = anotherAuthor.name;
        this.email = anotherAuthor.email;
        this.nationality = anotherAuthor.nationality;
    }
    
    /**
     * Checks to see if the nationality of the author is one of the following:
     * Canadian, American, French, British, German
     * 
     * @return If the nationality is valid.
     */
    public boolean isNationalityValid() {
        String[] validNationalities = {"Canadian", "American", "French", "British", "German"};
        
        for (String validNat : validNationalities)
            if (validNat.equals(this.nationality))
                return true;
        return false;
    }

    /**
     * Checks to see if two Objects are of the same type and has the same values.
     * 
     * @param obj The object being compared.
     * @return If both objects are equal to each other.
     */
    @Override
    public boolean equals(Object obj) {
        Author author = (Author) obj;
        
        if (!(obj instanceof Author))
            return false;
        
        return this.name.equals(author.name)
                && this.email.equals(author.email)
                && this.nationality.equals(author.nationality);
    }

    
    /**
     * Gets the name.
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name Sets the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email.
     * 
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * 
     * @param email Sets the email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the nationality.
     * 
     * @return The Nationality.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality.
     * 
     * @param nationality the nationality
     */
    public void setNationality(String nationality) {
        if(isNationalityValid())
            this.nationality = nationality;
        else
            System.out.println("Invalid Nationality");
    }
    
    
}
