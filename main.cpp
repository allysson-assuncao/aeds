#include <iostream>
#include <vector>

using namespace std;

void copy_vet1(vector<int> v1, vector<int> &v3) {
    for(int i = 0; i < v1.size() - 1; i++) {
        v3[i] = v1[i];
    }
}

void copy_vet2(int vet1_len, vector<int> v2, vector<int> &v3) {
    for(int i = vet1_len; i < v2.size() + vet1_len; i++) {
        v3[i] = v2[i - vet1_len];
    }
}

int main() {

    vector<int> v1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    vector<int> v2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    vector<int> v3;
    copy_vet1(v1, v3);
    copy_vet2(v1.size(), v2, v3);

    v3[0] = v1[0];
    cout << "[" << endl;
    for(int i : v3) {
        cout << i << ", ";
    }
    cout << "]" << endl;
    return 0;
}
