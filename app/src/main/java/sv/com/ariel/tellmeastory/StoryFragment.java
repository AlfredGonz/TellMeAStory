package sv.com.ariel.tellmeastory;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoryFragment extends Fragment {


    private ViewPager viewPager;

    public StoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.story_fragment, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //Request Location permission

        viewPager = getActivity().findViewById(R.id.vp_story);
        ViewPagerHomeAdapter adapter = new ViewPagerHomeAdapter(getChildFragmentManager());

        //Adding the fragments
        adapter.AddFragment(new BlankFragment(), "test");
        ///  adapter.AddFragment(new MechanicsFragment(), getString(R.string.MECANICOS));
        adapter.AddFragment(new BlankFragment(), "test");

        //Setting up the adapter
        viewPager.setAdapter(adapter);


    }


}
