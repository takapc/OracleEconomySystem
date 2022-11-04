package rpg.oracle.EconomySystem

import com.mongodb.client.MongoClients
import org.bukkit.plugin.java.JavaPlugin
import com.mongodb.MongoClientSettings

import com.mongodb.ConnectionString











class Main: JavaPlugin() {
    override fun onEnable() {
        logger.info("Hello Oracle!")

        System.setProperty("java.net.preferIPv4Stack" , "true")
        val connectionString = "mongodb://" + System.getenv("USER") + ":" + System.getenv("PASSWORD") + "@" + System.getenv("CLUSTER") + ".nkyz1vd.mongodb.net/"
        val mongoClient = MongoClients.create(connectionString)
        val database = mongoClient.getDatabase("UserInformation")
        val col = database.getCollection("money")
        val document = col.find().first()!!
        logger.info(document.getString("name"))
    }
}