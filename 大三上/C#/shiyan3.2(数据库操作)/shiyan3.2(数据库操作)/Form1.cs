using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace shiyan3._2_数据库操作_
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
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

        private void button1_Click(object sender, EventArgs e)
        {

        }
    }
}
