using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Lab3_1_
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        public void cal()
        {
            int value1=0, value2=0, sum;
            string str1 = textBox1.Text;
            if (textBox1.Text == "")
            {
                value1 = 0;
            }
            else
            {
                value1 = Convert.ToInt32(str1);
            }
            string str2 = textBox2.Text;
            if (textBox2.Text == "")
            {
                value2 = 0;
            }
            else
            {
                value2 = Convert.ToInt32(str2);
            }
            sum = value1 + value2;
            textBox3.Text = Convert.ToString(sum);
        }
        private void button1_Click(object sender, EventArgs e)
        {
            if ((textBox1.Text == "") && (textBox2.Text == ""))
            {
                cal();
            }
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            textBox3.ReadOnly = true;
        }
        private void textBox2_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!(Char.IsNumber(e.KeyChar)) && e.KeyChar != (char)13 && e.KeyChar != (char)8)
            {
                e.Handled = true;
                MessageBox.Show("请输入正确参数", "提示");
            }
        }
        
        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            cal();
        }
        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!(Char.IsNumber(e.KeyChar)) && e.KeyChar != (char)13 && e.KeyChar != (char)8)
            {
                e.Handled = true;
                MessageBox.Show("请输入正确参数", "提示");
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            cal();
        }
    }
}
