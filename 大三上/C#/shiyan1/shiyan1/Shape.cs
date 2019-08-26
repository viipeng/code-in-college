using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shiyan1
{
    public class Shape  
    {
        public int x, y;//图形的中心点

        public Shape() { }
        public Shape(int a, int b)
        {
            this.x = a;
            this.y = b;
        }
        public void drawShape() { }
        virtual public void move(int x1, int y1) { }
    }
    public class Rectangle : Shape
    {
        public int length, width;
        public new int x, y;//以左上角的交点作为矩形的坐标

        public Rectangle() { }
        public Rectangle(int a, int b, int c, int d)
        {
            length = a;
            width = b;
            this.x = c;
            this.y = d;
        }
        public void drawRectangle()
        {
            Console.WriteLine("画了一个矩形！");
        }
        public override void move(int x1, int y1)
        {
            this.x += x1;
            this.y += y1;
            Console.WriteLine("矩形已经移动了！");
        }
    }
    public class Round : Shape 
    {
        public int radius; //半径
        public new int x, y; //以圆心作为圆的中心点
        
        public Round() { }
        public Round(int a, int b, int c)
        {
            radius = a;
            this.x = b;
            this.y = c;
        }
        public void drawRound()
        {
            Console.WriteLine("画了一个圆！");
        }
        public override void move(int x1, int y1)
        {
            this.x += x1;
            this.y += y1;
            Console.WriteLine("圆已经移动了！");
        }
    }
    class Combination1 //组合一个圆与一个矩形
    {
        Rectangle rec = new Rectangle();
        Round rou = new Round();

        public Combination1(Rectangle re, Round ro)
        {
            this.rec = re;
            this.rou = ro;
        }
        public void combinate()
        {
            Console.WriteLine("一个圆与一个矩形已经组合！");
        }
        public void move(int x1, int y1)
        {
            rec.move(x1, y1);
            rou.move(x1, y1);
            Console.WriteLine("组合图形已经移动了！");
        }

    }
    class Combination2 : Shape //组合任意多个矩形和任意多个圆
    {
        List<Rectangle> recList = new List<Rectangle>();
        List<Round> rouList = new List<Round>();

        public Combination2(List<Rectangle> recList1, List<Round> rouList1)
        {
            foreach(Rectangle r1 in recList1)
            {
                recList.Add(r1);
            }
            foreach (Round r2 in rouList1)
            {
                rouList.Add(r2);
            }
        }
        public void combinate()
        {
            Console.WriteLine("任意多个矩形和任意多个圆已经组合！");
        }
        public void move(int x1, int y1)
        {
            foreach (Rectangle r1 in recList)
            {
                r1.move(x1, y1);
            }
            foreach (Round r2 in rouList)
            {
                r2.move(x1, y1);
            }
            Console.WriteLine("组合图形已经移动了！");
        }

    }
    class Combination3 //组合任意多个单个图形(不使用多态）
    {
        List<Shape> sha = new List<Shape>();

        public Combination3(List<Shape> sha1)
        {
            this.sha = sha1;
        }
        public void combinate()
        {
            Console.WriteLine("任意多个单个图形已经组合！");
        }
        public void move(int x1, int y1)
        {
            foreach (Shape s in sha)
            {
                if (s is Rectangle)
                {
                    ((Rectangle)s).move(x1, y1);
                }
                else if (s is Round)
                {
                    ((Round)s).move(x1, y1);
                }
            }
            Console.WriteLine("组合图形已经移动了！");
        }

    }
    class Combination4 //组合任意多个单个图形(使用多态）
    {
        List<Shape> sha = new List<Shape>();

        public Combination4(List<Shape> sha1)
        {
            this.sha = sha1;
        }
        public void combinate()
        {
            Console.WriteLine("任意多个单个图形已经组合！");
        }
        public void move(int x1, int y1)
        {
            foreach (Shape s in sha)
            {
                s.move(x1, y1);
            }
            Console.WriteLine("组合图形已经移动了！");
        }

    }
    class Combination5 : Shape //组合任意多个单个图形与任意多个组合图形
    {
        List<Shape> sha = new List<Shape>();
        List<Combination2> cbt2 = new List<Combination2>();

        public Combination5(List<Shape> sha1, List<Combination2> cbt)
        {
            this.sha = sha1;
            this.cbt2 = cbt;
        }
        public void combinate()
        {
            Console.WriteLine("任意多个单个图形与任意多个组合图形已经组合！");
        }
        public void move(int x1, int y1)
        {
            foreach (Shape s in sha)
            {
                s.move(x1, y1);
            }
            foreach (Combination2 c in cbt2)
            {
                c.move(x1, y1);
            }
            Console.WriteLine("组合图形已经移动了！");
        }

    }
}
