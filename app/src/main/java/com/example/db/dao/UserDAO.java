package com.example.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bean.User;
import com.example.constast.TABLES;
import com.example.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private SQLiteDatabase db;

    private DBHelper helper;

    public UserDAO(DBHelper helper) {
        this.helper = helper;

    }

    /**
     * 添加
     */
    public void add(User user) {
        db = helper.getReadableDatabase();

        ContentValues values=new ContentValues();
        values.put(TABLES.USER.NAME,user.getName());

        db.insert(TABLES.USER.TABLE_NAME,null,values);
        db.close();
    }


    /**
     * 删除
     */
    public void del(int id) {
        db = helper.getReadableDatabase();
        String whereClause=TABLES.USER.ID+"=?";
        String[] whereArgs={String.valueOf(id)};
        //delete from table   where id=?
        /**
         * 参数1：表名
         * 参数2：删除条件
         * 参数3：参数条件的值
         */
        db.delete(TABLES.USER.TABLE_NAME,whereClause,whereArgs);
        db.close();
    }

    /**
     * 修改
     */
    public void update(User user) {
        db = helper.getReadableDatabase();

        ContentValues values=new ContentValues();
        values.put(TABLES.USER.NAME,user.getName());

        String whereClause=TABLES.USER.ID+"=?";
        String[] whereArgs={String.valueOf(user.getId())};
        /**
         * 参数1：表名
         * 参数2：要修改的值
         * 参数3：修改条件
         * 参数4：修改条件的值
         */
        db.update(TABLES.USER.TABLE_NAME,values,whereClause,whereArgs);

        db.close();
    }

    /**
     * 查询所有
     */
    public List<User> queryAll() {
        List<User> users = new ArrayList<>();
        db = helper.getReadableDatabase();
        //SELECT ID,NAME,AGE FORM USER
        //String[] columns={TABLES.USER.NAME,TABLES.USER.AGE};
        Cursor cursor = db.query(TABLES.USER.TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(cursor.getColumnIndex(TABLES.USER.ID));
            String name=cursor.getString(cursor.getColumnIndex(TABLES.USER.NAME));
            User user =new User(id,name);
            //添加到集合
            users.add(user);
        }
        db.close();
        return users;
    }

    /**
     * 根据条件查询
     */
    public List<User> query(String mName) {
        List<User> users = new ArrayList<>();
        db = helper.getReadableDatabase();
        //String[] columns={TABLES.USER.NAME,TABLES.USER.AGE};
        String selection=TABLES.USER.NAME+" LIKE '%?%'";
        String[] selectionArgs={mName};
        Cursor cursor = db.query(TABLES.USER.TABLE_NAME, null, selection, selectionArgs, null, null, null, null);
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(cursor.getColumnIndex(TABLES.USER.ID));
            String name=cursor.getString(cursor.getColumnIndex(TABLES.USER.NAME));
            User user =new User(id,name);
            //添加到集合
            users.add(user);
        }
        db.close();

        return users;
    }

    /**
     * 查询一个
     */
    public User queryById(int mId) {
        db = helper.getReadableDatabase();
        User user = null;
        String selection=TABLES.USER.ID+"= ?";
        String[] selectionArgs={String.valueOf(mId)};
        Cursor cursor = db.query(TABLES.USER.TABLE_NAME, null, selection, selectionArgs, null, null, null, null);
        if (cursor.moveToNext())
        {
            int id=cursor.getInt(cursor.getColumnIndex(TABLES.USER.ID));
            String name=cursor.getString(cursor.getColumnIndex(TABLES.USER.NAME));
           user =new User(id,name);
        }
        db.close();
        return user;
    }


}
