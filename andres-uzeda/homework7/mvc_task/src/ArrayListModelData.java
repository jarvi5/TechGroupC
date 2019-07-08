import java.util.ArrayList;

public class ArrayListModelData {
    private ArrayList<Model> arrayModelList;
    private int positionToSearch;
    public ArrayListModelData(){
        this.arrayModelList = new ArrayList<>();
        this.positionToSearch = 0;
    }
    public ArrayList<Model> getArrayListModelData(){
        return arrayModelList;
    }
    public void setLinkedListModel(Model person){
        arrayModelList.add(person);
    }

    public String searchNext(){
        String name;
        if(positionToSearch < arrayModelList.size()){
            name = getFullNameFromModelArray(arrayModelList.get(positionToSearch));
            positionToSearch++;
            return name;
        }
        return "There aren't more values";
    }
    public String searchPrevious(){
        if(positionToSearch != 0){
            positionToSearch--;
            return getFullNameFromModelArray(arrayModelList.get(positionToSearch));
        }
        return getFullNameFromModelArray(arrayModelList.get(0));
    }
    private String getFullNameFromModelArray(Model model){
        return model.getFirstname() + ' ' + model.getLastname();
    }

    public String searchAPersonInToCollection(String fullName){
        for (Model m: arrayModelList) {
            if(getFullNameFromModelArray(m).equals(fullName)){
                return fullName + " is in the collection";
            }
        }
        return fullName + " is not in the collection";
    }
}
