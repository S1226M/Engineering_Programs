using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //ArrayList s = new ArrayList();
            //s.Add("Aa");
            //s.Add("Bb");
            //s.Add("Cc");
            //s.Add("Dd");
            ////s.Remove("Cc");
            ////s.Remove(s[1]);
            //s.RemoveRange(1, 2);
            //s.Clear();
            //foreach (object i in s) 
            //{
            //    Console.WriteLine(i);
            //}

            //List<string> list = new List<string>();
            //list.Add("A");
            //list.Add("D");
            //list.Add("F");
            //list.Add("G");
            //list.Add("U");
            //list.Remove("C");
            //list.Remove(list[1]);
            //list.RemoveRange(1, 2);
            //list.Clear();
            //foreach (object i in list)
            //{
            //    Console.WriteLine(i);
            //}

            //Stack stack = new Stack();
            //stack.Push(10);
            //stack.Push(20);
            //stack.Push("ADHJ");
            ////Console.WriteLine(stack.Pop()); 
            //Console.WriteLine(stack.Peek());
            //Console.WriteLine(stack.Contains("ADHJ"));
            //stack.Clear();
            //foreach (object i in stack)
            //{
            //    Console.WriteLine(i);
            //}

            //Queue queue = new Queue();
            //queue.Enqueue(1);
            //queue.Enqueue(2);
            //queue.Enqueue(3);
            //queue.Enqueue(4);
            //queue.Clear();
            //Console.WriteLine(queue.Dequeue());
            //Console.WriteLine(queue.Peek());
            //Console.WriteLine(queue.Contains(2));

            Dictionary<int, string> d = new Dictionary<int, string>();
            d.Add(1, "A");
            d.Add(2, "B");
            d.Add(3, "C");
            d.Remove(3);
            Console.WriteLine(d.ContainsKey(3));
            Console.WriteLine(d.ContainsValue("C"));
            d.Clear();
            foreach (object i in d.Keys)
            {
                Console.WriteLine(i);
            }

            Hashtable h = new Hashtable();
            h.Add(1, "A");
            h.Add(2, "B");
            h.Add(3, "C");

        }
    }
}
