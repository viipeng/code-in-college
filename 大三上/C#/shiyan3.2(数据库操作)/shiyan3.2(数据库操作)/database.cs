﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace shiyan3._2_数据库操作_
{
    public class database
    {
        private void linkDatabase(object sender, EventArgs e)
        {
            lable label1, label2;
            string str = "Server= mrwxk\\mrwxk; User Id= sa; Pwd= 11111; DataBase= Book";
            SqlConnection con = new SqlConnection(str);
            con.Open();
            if (con.State == ConnectionState.Open)
            {
                label1.Text = "SQL Server数据连接已打开！";
                con.Close();
            }
            if (con.State == ConnectionState.Closed)
            {
                label2.Text = "SQL Server数据库连接关闭!";
            }
        }
    }
}
