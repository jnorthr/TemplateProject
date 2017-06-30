 
//@Bindable
@groovy.beans.Bindable
class Address {  
    String street, number, city, state
    String toString() { "address[street=$street,number=$number,city=$city,state=$state]" }
}
  
def address = new Address(street: 'Evergreen Terrace', number: '742', city: 'Springfield',state:'Illinois')
  
def swingBuilder = new SwingBuilder()


