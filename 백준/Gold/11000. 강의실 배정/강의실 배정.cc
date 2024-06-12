#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;



int compareTo(pair<int, int> p1, pair<int, int> p2) {
	if (p1.first == p2.first) {
		return p1.second < p2.second;
	}
	return p1.first < p2.first;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<pair<int, int>> times;
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		int start, end;
		cin >> start >> end;
		times.push_back(pair<int, int>(start, end));
	}
	sort(times.begin(), times.end(), compareTo);
	priority_queue<int, vector<int>, greater<int>> pq;
	pq.push(times[0].second);
	times.erase(times.begin());
	for (pair<int, int> time : times) {
		if (time.first >= pq.top()) {
			pq.pop();
		}
		pq.push(time.second);
	}
	cout << pq.size() << "\n";
	return 0;
}