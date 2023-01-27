package kata6;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Comments {
    
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
    
    @XmlElement(name = "Post_id", required=true)
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    @XmlElement(name = "Id")
    public void setId(Integer id) {
        this.id = id;
    }
    
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }
    
    @XmlElement(name = "body")
    public void setBody(String body) {
        this.body = body;
    }
    
    @Override
    public String toString(){
        return "postID: " + this.postId + ",\n"
        + "id: " + this.id + ",\n"
        + "name: " + this.name + ",\n"  
        + "email: " + this.email + ",\n"  
        + "body: " + this.body  + "\n";
    }
    
    
    
           
    
}
