package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private String id;
    private String email;
    private String phone;
    private String displayName;
    private String address;
    private boolean marketingOptIn;
    private String twitter;
    private String github;

    public static class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;
        Builder setId(String ids){
            this.id = ids;
            return this;
        }
        Builder setEmail(String email){
            this.email = email;
            return this;
        }
        Builder setDisplayName(String name){
            this.displayName = name;
            return this;
        }
        Builder setAddress(String addr) {
            this.address =addr;
            return this;
        }
        Builder setMarketingOptIn(boolean mrkt){
            this.marketingOptIn = mrkt;
            return this;
        }
        Builder setTwitter(String x){
            this.twitter = x;
            return this;
        }
        Builder setGithub(String git){
            this.github = git;
            return this;
        }
        UserProfile Build(){
            Validation.requireEmail(email);
            // Validation.requireNonBlank(displayName, "displayName");
            Validation.requireNonBlank(id, "id");
            return new UserProfile(this);
        }
    }

    UserProfile(Builder bldr) {
        this.address = bldr.address;
        this.displayName = bldr.displayName;
        this.email = bldr.email;
        this.github = bldr.github;
        this.id = bldr.id;
        this.marketingOptIn = bldr.marketingOptIn;
        this.phone = bldr.phone;
        this.twitter = bldr.twitter;
    }

    // public UserProfile(String id, String email) {
    //     this.id = id;
    //     this.email = email;
    // }

    // public UserProfile(String id, String email, String phone) {
    //     this(id, email);
    //     this.phone = phone;
    // }

    // // many setters — mutability leaks
    // public void setId(String id) { this.id = id; }
    // public void setEmail(String email) { this.email = email; }
    // public void setPhone(String phone) { this.phone = phone; }
    // public void setDisplayName(String displayName) { this.displayName = displayName; }
    // public void setAddress(String address) { this.address = address; }
    // public void setMarketingOptIn(boolean marketingOptIn) { this.marketingOptIn = marketingOptIn; }
    // public void setTwitter(String twitter) { this.twitter = twitter; }
    // public void setGithub(String github) { this.github = github; }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }
}
