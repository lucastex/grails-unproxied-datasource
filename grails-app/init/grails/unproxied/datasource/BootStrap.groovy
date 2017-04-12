package grails.unproxied.datasource

class BootStrap {

    def init = { servletContext ->

        new Contact(name: "Big Ben Roethlisberger", email: "theone@bigbenland.com.br").save()
        new Contact(name: "Odell Beckham Jr", email: "obj@nygiants.com").save()
        new Contact(name: "Aaron Rodgers", email: "arodgers@gopackers.com").save()
    }
    def destroy = {
    }
}
