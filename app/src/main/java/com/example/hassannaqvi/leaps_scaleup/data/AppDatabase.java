package com.example.hassannaqvi.leaps_scaleup.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Participant;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Users;

@Database(entities = {Forms.class, Forms_04_05.class, Clusters.class, Users.class, Participant.class}, version = AppDatabase.Sub_DBConnection.DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // Alter table for Database Update
    private static final Migration MIGRATION_v1_v2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE forms " + " ADD COLUMN last_update TEXT");
            database.execSQL("CREATE TABLE " + Sub_DBConnection.TABLE_PARTICIPANT + "("
                    + Participant.SinglePart._ID + " INTEGER,"
                    + Participant.SinglePart.COLUMN_STUDY_ID + " TEXT,"
                    + Participant.SinglePart.COLUMN_PART_NAME + " TEXT,"
                    + Participant.SinglePart.COLUMN_PART_TYPE + " TEXT, PRIMARY KEY(" + Participant.SinglePart._ID + ") );");
        }
    };

    private static AppDatabase sInstance;

    public static AppDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, Sub_DBConnection.DATABASE_NAME)
                            .addMigrations(MIGRATION_v1_v2)
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build();
                }
            }
        }
        return sInstance;
    }

    public abstract FormsDAO formsDao();

    public abstract GetFncDAO getFncDao();

    public interface Sub_DBConnection {
        String DATABASE_NAME = "leaps_sup";
        int DATABASE_VERSION = 2;
        String TABLE_FORMS = "forms";
        String TABLE_FORMS_04_05 = "forms_04_05";
        String TABLE_PARTICIPANT = "participants";
        String TABLE_USERS = "users";
        String TABLE_CLUSTERS = "clusters";
    }
}
