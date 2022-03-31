#include <cstdlib>
#include <iostream>
#include <queue>
#include <map>
#include <string>
using namespace std;
void showq(
    priority_queue<int, vector<int>, greater<int> > q)
{
    priority_queue<int, vector<int>, greater<int> > g = q;
    while (!g.empty()) {
        cout << '\t' << g.top();
        g.pop();
    }
    cout << '\n';
}
void showp(priority_queue<int> p)
{
    priority_queue<int> g = p;
    while (!g.empty()) {
        cout << '\t' << g.top();
        g.pop();
    }
    cout << '\n';
}
int main() {
    int t;
    cin>>t;
    for(int i=0;i<t;i++){
        priority_queue<int>p;
        priority_queue<int, vector<int>,greater<int> > q;
        string id;
        int people,floors,office;
        cin>>id;
        cin>>people;
        cin>>floors;
        cin>>office;
        int building[floors][office];
        int v=floors*office;
    for(int j=0;j<floors;j++){
        for(int k=0;k<office;k++){
            building[j][k]=v;
            v--;
        }
    }
        int floorup[people];
        int floordown[people];
        string name[people];
        for(int j=0;j<people;j++){
            
            int fa,fb,fe;
            cin>>name[j]>>fa>>fb;
              for(int k=0;k<floors;k++){
                for(int m=0;m<office;m++){
                    if(fb==building[k][m]){
                        fe=k+1;
                        break;
                    }
               }
           }    
            if(fa<fe){
                q.push(fe);
                floorup[j]=fe;
            }else{
               p.push(fe);
               floordown[j]=fe;
            }
            
        }
        
        while (!q.empty()) {
            for(int a=0;a<people;a++){
            if(q.top()==floorup[a]){
                cout<<name[a]<<endl;
                floorup[a]=-1;
            }
            }
        q.pop();
       }
        
    while (!p.empty()) {
        for(int a=0;a<people;a++){
        if(p.top()==floordown[a]){
                cout<<name[a]<<endl;
                floordown[a]=-1;
            }
        }
        p.pop();
        
    }
     
}
    return 0;
}
