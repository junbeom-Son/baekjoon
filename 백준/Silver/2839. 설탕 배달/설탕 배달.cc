#include <iostream>
using namespace std;
int main() {
	int sugar;
	cin >> sugar;
	if (sugar < 5) {
		if (sugar == 3) {
			cout << 1;
		}
		else cout << -1;
	}
	else if (sugar >= 5) {
		switch (sugar % 5) {
		case 0:
			cout << sugar / 5;
			break;
		case 1:
			cout << (sugar / 5) - 1 + 2;
			break;
		case 2:
			if (sugar == 7) {
				cout << -1;
				break;
			}
			else {
				cout << (sugar / 5) - 2 + 4;
			} break;
		case 3:
			cout << sugar / 5 + 1;
			break;
		case 4:
			cout << sugar / 5 - 1 + 3;
			break;
		}
	}
	return 0;
}