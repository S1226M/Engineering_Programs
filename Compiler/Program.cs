// See https://aka.ms/new-console-template for more information
using System;
namespace Program
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Console.Write("> ");
                var line = Console.ReadLine();
                if (string.IsNullOrWhiteSpace(line))
                    return;

                if (line == "1+2*3")
                    Console.WriteLine("7");
                else
                    Console.WriteLine("ERROR: Invalid expression");
            }
        }
    }

    class SyntexToken
    {
        public SyntexToken(SyntexKind kind, int position, string text)
        {
            Kind = kind;
            Position = position;
            Text = text;
        }
        public SyntexKind kind { get; }
    }

    class Lexer
    {
        private int _position;
        public Lexer(string text)
        {
            _text = text;
        }

        public SyntexToken NextToken()
        {

        }
    }
}