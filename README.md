# bottomsheetrecycler
BottomSheet Multiple RecyclerView

#### One of the solutions of multiple RecyclerView/ScrollView in BottomSheetBehavior
#### Usage

[See demo apk](/app-debug.apk)

Copy com.matcontrol.control classes to Your project.

Use BottomSheetBehaviorv2 instead BottomSheetBehavior

RecyclerView/Scroll view mast have CoordinatorLayout parent.

For ease to use added BottomSheetBehaviorRecyclerManager class

```
    BottomSheetBehaviorRecyclerManager manager = 
    new BottomSheetBehaviorRecyclerManager(parentCoordinator, behavior, bottomsheetview);
    manager.addControl(recyclerview);
    manager.addControl(recyclerview);
    manager.create();
```

#### For other details see example application