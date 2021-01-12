

#include <iostream>
#include <vector>
#include <string>


using namespace std;


vector<string> restoreIpAddresses(string s);
void dfs(string s, int pos, vector<string> &path, vector<string> &result);
/**
  Given a string containing only digits,
  restore it by returning all possible valid IP address combinations.
  Example:
  Input: "25525511135"
  Output: ["255.255.11.135", "255.255.111.35"]
*/
vector<string> restoreIpAddresses(string s) {
    vector<string> result;
    vector<string> path;

    dfs(s, 0, path, result);
    return result;
    
}

void dfs(string s, int pos, vector<string> &path, vector<string> &result) {

    cout<<path.size()<<"\t"<<pos<<"\t"<<s.size()<<endl;
    if (path.size() > 4)
        return;

    if (path.size() == 4) {
        for (auto c : path) {
            cout<<c<<"\t";
        }
        cout<<endl;
    }
    if (path.size() == 4 && pos == s.size()) {
        result.push_back(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
        return;
    }

    // 剪枝
    if (s.size() - pos > (4 - path.size()) * 3)
        return;


    int num = 0;
    for (int i = 1; i < 4; i++) {
        if (pos + i > s.size())
            break;

        num = 10 * num + (s[pos + i - 1] - '0');
        //num = 10 * num + (s[pos + i] - '0');
        if (num > 255)
            break;

        //cout<< num <<"\t" << s.substr(pos,i)<<endl;
        //cout<<s.substr(pos, i)<<endl;
        path.push_back(s.substr(pos, i));
        dfs(s, pos + i, path, result);
        path.pop_back();


        // 前缀不为0，path弹出最近的路径后，如果num为0，则说明当前i位为0，break;
        if (num == 0)
            break;
    }
}




int main(int argc, char const *argv[]) {

    string s = "100111";
    vector<string> result = restoreIpAddresses(s);
    for (auto c :result) {
        cout<<c<<endl;
    }

    return 0;
}
