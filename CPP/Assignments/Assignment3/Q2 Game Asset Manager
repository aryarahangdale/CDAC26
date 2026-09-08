

#include <iostream>
#include <memory>
using namespace std;

class Texture{
	string name;
	int width;
	int height;

public:
	Texture(string name, int width, int height): name(name), width(width), height(height){
		cout<<" [Texture Loaded]"<<endl;
	}

	~Texture(){
			cout<<" [Texture Released]"<<endl;
		}

	void display() const{

	}
};

class Shader{

	string name;
	string type;

public:
	Shader(string name, string type): name(name), type(type){
		cout<<"[Shader Compiled]"<<endl;
	}

	~Shader(){
			cout<<"[Shader Destroyed]"<<endl;
		}

	void display() const{

	}
};

class AudioClip{
public:
	string name;
	float value;
	AudioClip(string name, float v): name(name), value(v){

	}

	~AudioClip(){

	}
};

int main() {
// ------------------------------------Unique Pointer-----------------------------------------------------------
//	auto tex1 = make_unique<Texture>("player_sprite", 512, 512);
//	tex1->display();
// a unique pointer as the name tells that the resource is exclusively owned by it, there could be a single owner of that particular
// resource thereforce you cannot assign this pointer to another one.
//	unique_ptr<Texture> tex2 = tex1;
//-------------------------------------------------------------------------------------------------------------
//	unique_ptr<Texture> tex2 = move(tex1);
//	cout << "tex1 is null: " << (tex1 == nullptr ? "YES" : "NO") << endl;

//----------------------------------Shared Pointer------------------------------------------------------------
//	auto shader = make_shared<Shader>("main_vert", "vertex");
//	cout << "Ref count: " << shader.use_count() << endl; // 1
//	{
//	 auto rendererRef = shader;
//	 cout << "Ref count: " << shader.use_count() << endl; // 2
//
//	 auto editorRef = shader;
//	 cout << "Ref count: " << shader.use_count() << endl; // 3
//	}
//	cout << "Ref count: " << shader.use_count() << endl; // 1

//----------------------------------Weak Pointer----------------------------------------------------------------------
	auto audio = make_shared<AudioClip>("explosion", 3.5);
	weak_ptr<AudioClip> observer = audio;
	if (auto clip = observer.lock()){
		cout<<"Use Count: "<< audio.use_count()<<endl; //will be 2 temporary
		cout << "Clip alive: " << clip.get()->name<<endl;
	}
	audio.reset(); // unload
	if (observer.expired())
	 cout << "Clip already unloaded." << endl;

	return 0;
}
