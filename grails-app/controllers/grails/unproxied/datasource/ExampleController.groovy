package grails.unproxied.datasource

import groovy.sql.Sql

class ExampleController {

    def dataSourceUnproxied

    def index() {

        //unproxiedDataSource ref
        def sql = new Sql(dataSourceUnproxied)

        //output buffer
        def sb = new StringBuilder()

        def total = Contact.count()
        sb.append("Initial total: ${total}\n") //counting from the proxied DS

        new Contact(name: "GOAT", email: "peytonmanning@broncos.com").save()

        def proxiedTotal = Contact.count()
        def unproxiedToatl = sql.firstRow("select count(1) total from contact").total

        sb.append("Total from the proxied DataSource: ${proxiedTotal}\n")
        sb.append("Total from the unproxied DataSource: ${unproxiedToatl}")

        //render the generated buffer
        response.setContentType("text/plain")
        render sb.toString()

    }
}
