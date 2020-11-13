package com.example.hassannaqvi.leaps_scaleup.data.entities

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase
import org.json.JSONObject

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FO)
class FO {

    @PrimaryKey(autoGenerate = true)
    var _id: Int = 0

    @ColumnInfo
    var fid: String = ""
    var fname: String = ""

    fun Sync(jsonObjectCls: JSONObject): FO {
        this.fid = jsonObjectCls.getString(FOTable.COLUMN_F_ID)
        this.fname = jsonObjectCls.getString(FOTable.COLUMN_F_NAME)
        return this
    }

    internal object FOTable : BaseColumns {
        const val COLUMN_F_ID = "fid"
        const val COLUMN_F_NAME = "fname"
    }

}