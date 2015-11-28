package org.jmcgill2.database

import groovy.sql.Sql

/**
 * Created by jamesmcgill on 11/26/15.
 */
class MultipleConnections {

    public static void main(String[] args) {
        MultipleConnections mc = new MultipleConnections()
        mc.run()
    }

    def run() {

        def conn = Sql.newInstance("jdbc:postgresql://localhost/Junk", "postgres", "admin", "org.postgresql.Driver")
        def conn2 = Sql.newInstance("jdbc:postgresql://localhost/Junk", "postgres", "admin", "org.postgresql.Driver")
        def cnt = conn.firstRow("select count(*) as cnt from sierra").cnt
        def cnt2 = conn2.firstRow("select count(*) as cnt from sierra").cnt
        println "cnt = $cnt and cnt2 = $cnt2"

        def h2Conn = Sql.newInstance("jdbc:h2:~/things", "sa", "sa", "org.h2.Driver")

//          def createTable = "create table junk (id int, name char(100), description char(255))"

//        h2Conn.execute(createTable)

//        h2Conn.executeInsert("insert into junk values (1, 'Sierra', 'Sierra is Awesome')")
//        h2Conn.executeInsert("insert into junk values (2, 'Tami', 'Tami is Awesome')")
//        h2Conn.executeInsert("insert into junk values (3, 'Jim', 'Jim is NOT Awesome')")
//        h2Conn.executeInsert("insert into junk values (3, 'Jim', 'Jim is NOT Awesome')")

        def cnt3 = h2Conn.firstRow("select count(*) as cnt from junk").cnt

        println "cnt3 = $cnt3"
    }
}
