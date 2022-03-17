#include <iostream>
#include <stack>
#include <queue>
using namespace std;
int main()
{
    int n, input, max = 0, lastValue = 0;
    bool possible = true;
    stack<int> s;
    queue<char> q;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> input;
        if (input > lastValue) {
            if (input < max) {
                possible = false;
                break;
            }
            else {
                while (max < input) {
                    max++;
                    s.push(max);
                    q.push('+');
                }
                s.pop();
                q.push('-');
            }
        }
        else {
            if (s.empty()) {
                possible = false;
                break;
            }
            while (s.top() > input) {
                s.pop();
                q.push('-');
            }
            if (s.top() == input) {
                s.pop();
                q.push('-');
            }
            else {
                possible = false;
                break;
            }
        }
        lastValue = input;
    }
    if (possible) {
        while (!q.empty()) {
            cout << q.front() << "\n";
            q.pop();
        }
    }
    else {
        cout << "NO" << endl;
    }
    return 0;
}