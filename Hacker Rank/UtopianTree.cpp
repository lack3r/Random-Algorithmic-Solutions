/*
Problem:    Utopian Tree
-------------------------
https://www.hackerrank.com/challenges/utopian-tree
Andreas Loizou @lack3r
August 2014
Time Complexity:  O(1)
*/
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
using namespace std;

//Instead of running a loop, I just solved manually two recursive functions.
//One for the odd n and one for the even
//The one is : f(n) = 2f(n-2) +1 = 2^k*f(n-2k) + \sum_{i=0}^{k-1}(2^i) === (n-2k=0)==>2^{n/2} + ((1-2^{n/2})/(1-2)) = n^{(n+2)/2} - 1
//The other is: f(n) = 2*(f(n-2) +1) = 2^k*f(n-2k) + \sum_{i=1}^{k}(2^i) ==(n-2k=1)===>2^{(n-1)/2}*2 + 2^{(n-1)/2} + 2^{(n-1)/2} -1 -1 = 4*2^{(n-1)/2}-2
//note: \sum_{i=0}^{n-1} (a^i) = (1-a^n)/(1-a)
//And by calculating manually the recursive function, HERE WE HAVE A O(1) SOLUTION
int height(int n) {
    if (n<0){return 0;}
    if (n==0){return 1;}
    if (n==1){return 2;}
    if (n%2==0) {return pow(2,(n+2)/2)-1;}
    return 4*pow(2,(n-1)/2) -2;
}
int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        cout << height(n) << endl;
    }
}
