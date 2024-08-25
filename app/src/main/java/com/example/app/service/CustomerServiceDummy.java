package com.example.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceDummy {
    private class Customer {

        private String id;
        private String name;
        private String email;
        private String mobile;
        private String age;
        private String gender;
        private String profile_img;
        private String username;
        private String password;

        // Constructor
        Customer(String id,String name, String email, String mobile, String age, String gender, String profile_img,
                String username, String password) {
                    this.id=id;
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            this.age = age;
            this.gender = gender;
            this.profile_img = profile_img;
            this.username = username;
            this.password = password;
        }

        // Getters and Setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getProfile_img() {
            return profile_img;
        }

        public void setProfile_img(String profile_img) {
            this.profile_img = profile_img;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer("1", "Riya Sharma", "riya.sharma@example.com", "9876543211", "28", "F", "example.com/profile/image1.png", "riya_sharma", "riya_sharma"),
        new Customer("2", "Amit Patel", "amit.patel@example.com", "9876543212", "30", "M", "example.com/profile/image2.png", "amit_patel", "amit_patel"),
        new Customer("3", "Priya Gupta", "priya.gupta@example.com", "9876543213", "22", "F", "example.com/profile/image3.png", "priya_gupta", "priya_gupta"),
        new Customer("4", "Arjun Reddy", "arjun.reddy@example.com", "9876543214", "27", "M", "example.com/profile/image4.png", "arjun_reddy", "arjun_reddy"),
        new Customer("5", "Ananya Singh", "ananya.singh@example.com", "9876543215", "26", "F", "example.com/profile/image5.png", "ananya_singh", "ananya_singh"),
        new Customer("6", "Vikram Saini", "vikram.saini@example.com", "9876543216", "29", "M", "example.com/profile/image6.png", "vikram_saini", "vikram_saini"),
        new Customer("7", "Meera Rao", "meera.rao@example.com", "9876543217", "25", "F", "example.com/profile/image7.png", "meera_rao", "meera_rao"),
        new Customer("8", "Ravi Kumar", "ravi.kumar@example.com", "9876543218", "31", "M", "example.com/profile/image8.png", "ravi_kumar", "ravi_kumar"),
        new Customer("9", "Neha Kapoor", "neha.kapoor@example.com", "9876543219", "23", "F", "example.com/profile/image9.png", "neha_kapoor", "neha_kapoor"),
        new Customer("10", "Vishal Mehta", "vishal.mehta@example.com", "9876543220", "32", "M", "example.com/profile/image10.png", "vishal_mehta", "vishal_mehta"),
        new Customer("11", "Sunita Desai", "sunita.desai@example.com", "9876543221", "29", "F", "example.com/profile/image11.png", "sunita_desai", "sunita_desai"),
        new Customer("12", "Rajesh Kumar", "rajesh.kumar@example.com", "9876543222", "35", "M", "example.com/profile/image12.png", "rajesh_kumar", "rajesh_kumar"),
        new Customer("13", "Anita Agarwal", "anita.agarwal@example.com", "9876543223", "26", "F", "example.com/profile/image13.png", "anita_agarwal", "anita_agarwal"),
        new Customer("14", "Deepak Jain", "deepak.jain@example.com", "9876543224", "28", "M", "example.com/profile/image14.png", "deepak_jain", "deepak_jain"),
        new Customer("15", "Ritika Sinha", "ritika.sinha@example.com", "9876543225", "24", "F", "example.com/profile/image15.png", "ritika_sinha", "ritika_sinha")
        

    ));

    // Create a new Customer
    public boolean createCustomer(String id, String name, String email, String mobile, String age, String gender, String profile_img, String username, String password) {
        // Check if a customer with the same ID already exists
        if (getCustomerById(id) != null) {
            return false; // Customer ID already exists
        }

        // Create and add the new customer
        Customer newCustomer = new Customer(id, name, email, mobile, age, gender, profile_img, username, password);
        customers.add(newCustomer);
        return true;
    }

    // Delete a Customer by ID
    public boolean deleteCustomerById(String id) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId().equals(id)) {
                iterator.remove(); // Remove the customer from the list
                return true; // Customer deleted successfully
            }
        }
        return false; // Customer not found
    }

    // Get Customer by ID
    public Customer getCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    // Get Customer by Username
    public Customer getCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    // Get Customer by Email
    public Customer getCustomerByEmail(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    // Get Customer by Username and Password
    public Customer getCustomerByUsernamePassword(String username, String password) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    // Get All Customers
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Update Customer's Name
    public boolean updateCustomerName(String id, String newName) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setName(newName);
            return true;
        }
        return false;
    }

    // Update Customer's Email
    public boolean updateCustomerEmail(String id, String newEmail) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setEmail(newEmail);
            return true;
        }
        return false;
    }

    // Update Customer's Mobile
    public boolean updateCustomerMobile(String id, String newMobile) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setMobile(newMobile);
            return true;
        }
        return false;
    }

    // Update Customer's Age
    public boolean updateCustomerAge(String id, String newAge) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setAge(newAge);
            return true;
        }
        return false;
    }

    // Update Customer's Gender
    public boolean updateCustomerGender(String id, String newGender) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setGender(newGender);
            return true;
        }
        return false;
    }

    // Update Customer's Profile Image
    public boolean updateCustomerProfileImg(String id, String newProfileImg) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setProfile_img(newProfileImg);
            return true;
        }
        return false;
    }

    // Update Customer's Username
    public boolean updateCustomerUsername(String id, String newUsername) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setUsername(newUsername);
            return true;
        }
        return false;
    }

    // Update Customer's Password
    public boolean updateCustomerPassword(String id, String newPassword) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // Update Multiple Customer Fields
    public boolean updateCustomerData(String id, String name, String email, String mobile, String age, String gender, String profile_img, String username, String password) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            if (name != null) customer.setName(name);
            if (email != null) customer.setEmail(email);
            if (mobile != null) customer.setMobile(mobile);
            if (age != null) customer.setAge(age);
            if (gender != null) customer.setGender(gender);
            if (profile_img != null) customer.setProfile_img(profile_img);
            if (username != null) customer.setUsername(username);
            if (password != null) customer.setPassword(password);
            return true;
        }
        return false;
    }

}
