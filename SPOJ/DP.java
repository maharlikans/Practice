Dynamic Programming, aka DP. is the general
algorithmic technique of solving a problem
that has a lot of similar subproblems.

It makes algorithms more efficient because
the subproblems are only calculated once
instead of many times.

Let's do an easy to understand example.







Problem:
We are given a number n, and we want
to calculate the n-th fibonacci number.

Assume that F(0) = 1 and F(1) = 1, and
that F(i) = F(i-1) + F(i-2)

How is it done?

We have a recursive formula already given to us,
so what we need to do is implement it.









// Naive recursion implementation

int fib(int n) {
  if (n <= 1)
    return 1;
  return fib(n-1) + fib(n-2);
}

Why is it naive?








// Memoization solution

int[] f = new int[MAX];
Arrays.fill(f, -1);

int fib(int n) {
  if (n <= 1)
    return 1;
    
  if (f[n] == -1)
    f[n] = fib(n-1) + fib(n-2);

  return f[n];
}





// Bottom-up DP solution (iterative)

int fib(int n) {
  int[] f = new int[n+2];
  f[0] = 1;
  f[1] = 1;
  for (int i = 2; i < f.length; ++i) {
    f[i] = f[i-1] + f[i-2];
  }
  return f[n];
}






======


Problem:
We have some pairs of brackets.
We want to calculate how many different ways we
can place the brackets so that we get a
"well-formed" expression.

For example,
If we have 3 pairs of brackets, we can make
()()()
()(())
(())()
(()())
((()))

5 different arrangements.

I'll give you a moment to think about it a bit.







// A Naive solution:

Well, we know how to do permutations, right?

So we just make a char array with

((((())))) 

if n = 5,
then we check all the permutations
and we then have a function to make sure it is
"well-formed"

What's the runtime?







// analyze the problem
We can tell this is dp for a few reasons:
1. When we form a "well-formed" paren expression
of N pairs of parens, you can see that smaller
parts of the expression are "well-formed"
expressions with fewer numbers of pairs

For example:
(())(()()())

There are 6 pairs of parens here, and we can see
that it is "broken" into two parts, the left side
a well-formed expr of 2 pairs, and the right a 
well-formed expr of 4 pairs.

So using the idea of breaking the problem into
parts, we can come up with this recursive formula:

We'll define A[N] to be "the number of well-formed
" expressions with N pairs of parenthesis"

Then we want to combine every way of breaking
So A[N] = A[1]*A[N-1] + A[2]*A[N-2] + ...

Right...?

()()() (())

Not quite.  If we have the expression
()()()()()

Then it could be broken up in several ways, which
means that we are going to be overcounting.

But it felt like we were on the right track, so
let's try again.
Instead of trying to break the problem down based
on "breaks", here is another way:

We can group the parentheses expressions together
based off of the very first pair.

(????)?????

So we think of it as "how many paren pairs are 
"contained inside the very first pair"
then multiply by
"how many paren pairs remain to the right?"

So for 6 pairs, we can break it up like so:

(0 pairs) 5 pairs
(1 pair ) 4 pairs
(2 pairs) 3 pairs
(3 pairs) 2 pairs
(4 pairs) 1 pair = ( ()()()() ) ()
(5 pairs) 0 pairs = ( ()()()()() )

A[5] * A[0]

So the actual recursive representation is

A[N] = A[0]*A[N-1] + A[1]*A[N-2] + ...

Right...?



We don't overcount things this time because there
can be no overlap between the ways we've broken
the problem

But do we get everything?

Yes, because we've gone over every possible way
that the first pair of parenthesis can be arranged






// Memoization
int MAX_N = the maximum possible input
int[] dp = new int[MAX_N + 1]
Arrays.fill(dp, -1);

int doIt(int num_parens) {
  // base cases
  if (num_parens == 0)
    return 1;
  if (dp[num_parens] == -1) {
    dp[num_parens] = 0;
    for (int in = 0; in < num_parens; ++in) {
      dp[num_parens] +=
        doIt(in) * doIt(num_parens-in-1);
    }
  }
  return dp[num_parens];
}

A good question: Why is the base case for 0, 1?
Part of the reason could be intuition -
"There is 1 way to do nothing"
The other part is that you could 'solve' for dp[0]
when you use the recursive formula for dp[1]:
dp[1] = dp[0] * dp[1 - 0 - 1] = dp[0] * dp[0];

But dp[1] we know is 1:   ()
So that means dp[0] should be 1 or -1 to make it
work, and 1 makes more sense than -1.



// bottom-up DP

int doIt(int parens) {
  int[] dp = new int[parens+1];
  dp[0] = 1;
  for (int subtot = 1; subtot <= parens; ++subtot)
  {
    dp[subtot] = 0;
    for (int in = 0; in < subtot; ++in) {
      dp[subtot] += dp[in] * dp[subtot - in - 1];
    }
  }
  return dp[parens];
}



For these problems, we analyzed them and then came
up with a recursion.  It was somewhat tough to do
so, but with practice that gets easier.

Other problems that involve dp don't always have
straight-forward recursive formulas, with arrays,
anyway.

So to do a bottom-up DP, you'd need to iterate
through the elements in a different way.

For example, Djikstra's Algorithm, and algorithms
on graphs in general.

So I'll give a slightly more general way to think of DP problems.

When I think of them, I try to understand what the
states of the problem are, and then I try to
understand the movement between the states.

In the Fibonacci problem, the state is just
F[N] = "the N-th fibonacci number"
and movement between the states is the recursive
formula:  F[N] = F[N-1] + F[N-2]

In the Parentheses problem, the state is again
A[N] = "the number of well-formed parentheses
"expressions with N pairs of parentheses"

and the movement was more complicated, as in the
recursive formula described.


A more complicated example is the Knapsack problem
I'll just describe the problem, and then the
states in the problem and the movement between
states

So in the Knapsack problem, we have a sack which
can hold a maximum weight W, and we have N items
each of which has a value v[i] and a weight w[i].

The question is to find what the maximum amount of
value we can fit into the sack without going over
the weight.

All the values and weights are integers.

So a bit of analysis on the problem will reveal
that the maximum value might not happen if we use
all the weight we can, so we'd need to come up
with a better way.

I'll describe the states then as
dp[K] = "the most amount of value we can get so
"far when using K total weight"

Then the movement is based on the item 'i' we are
looking at:
dp[K] = MAX{ dp[K], dp[K - w[i]] + v[i] }

It is not obvious at all that this little line
describes both possible movement and all movement,
just like how before it was easy to make a mistake
when coming up with the formula for
the Paren problem.



Ok, so time to practice lots of problems.

