package nibm.hd231.adapterviews

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(val context: Context): SQLiteOpenHelper(
    context,
    DB_NAME,
    null,
    DB_VERSION
) {
    companion object {
        const val DB_NAME: String = "my_articles"
        const val DB_VERSION: Int = 1
    }
    override fun onCreate(db: SQLiteDatabase?) {
        var query: String = "CREATE TABLE articles(category TEXT, article_name TEXT, content TEXT)"
        db?.execSQL(query)
        query = "INSERT INTO articles VALUES('sports', 'Football Championship')"
        db?.execSQL(query)
    }
    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        if (oldVersion == 1) {
            //Changes to be performed to upgrade the db version to new version
            //Change will include for DB version 2, DB version 3
        }else if (oldVersion == 2) {
            //Changes to be performed to upgrade the db version from version 2
            //Change will include for DB version 3
        }
        var query = "DROP TABLE contacts"
        db?.execSQL(query)
        onCreate(db)
    }
    public fun insertContact(name: String, number: String): Boolean {
        //Make the db as writable
        val db: SQLiteDatabase= this.writableDatabase
        val content: ContentValues= ContentValues()
        content.put("name", name)
        content.put("number", number)
        db.insert("contacts", null, content)
        return true
    }
    public fun updateContact(name: String, number: String): Boolean {
        //Make the db as writable
        val db: SQLiteDatabase= this.writableDatabase
        val content: ContentValues= ContentValues()
        content.put("number", number)
        db.update(
            "contacts",
            content,
            "name = ?",
            arrayOf(name)
        )
        return true
    }
    public fun deleteContact(name: String): Boolean {
        //Make the db as writable
        val db: SQLiteDatabase= this.writableDatabase
        db.delete(
            "contacts",
            "name = ?",
            arrayOf(name)
        )
        return true
    }
    public fun getContacts(): Cursor {
        //Make the db as readable
        val db: SQLiteDatabase= this.readableDatabase
        return db.rawQuery(
            "SELECT * FROM contacts",
            null
        )
    }
}
