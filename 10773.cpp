#include <iostream>
#include <stack>

using namespace std;

int main() {
	int n;
	cin >> n;
	long long result = 0, cmd;
	stack<long long> s;
	for (int i = 0; i < n; i++) {
		cin >> cmd;
		if (cmd == 0) s.pop();
		else s.push(cmd);
	}
	while (!s.empty()) {
		result += s.top();
		s.pop();
	}
	cout << result << endl;

	return 0;
}