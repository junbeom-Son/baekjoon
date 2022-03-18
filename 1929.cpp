#include <iostream>
#include <memory>
using namespace std;

void SieveOfEratosthenes(int m, int n)
{
    
    auto sieve = make_unique<bool[]>(n + 1);
    int aCursor = 2;
    for (int i = 0; i <= n; i++) {
        sieve[i] = true;
    }
    while (aCursor * aCursor <= n) {
        if (sieve[aCursor] == true) {
            for (int i = aCursor * aCursor; i <= n; i += aCursor) {
                sieve[i] = false;
            }
        }
        aCursor++;
    }
    for (int i = m; i <= n; i++) {
        if (sieve[i] == true) cout << i << endl;
    }
    return;
}

int main()
{
    int m, n;
    cin >> m >> n;
    SieveOfEratosthenes(m, n);
    return 0;
}