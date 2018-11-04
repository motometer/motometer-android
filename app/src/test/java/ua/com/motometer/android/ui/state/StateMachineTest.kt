package ua.com.motometer.android.ui.state

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.State
import ua.com.motometer.android.ui.state.home.Home
import ua.com.motometer.android.ui.state.home.NewRecord
import ua.com.motometer.android.ui.state.home.RecordType
import ua.com.motometer.android.ui.state.home.RecordTypeChoice

internal class StateMachineTest {

    @ParameterizedTest
    @MethodSource(value = ["garage", "home"])
    fun changeState(currentState: State, action: Action, expectedState: State) {

        val result = currentState.changeState(action)

        assertThat(result).isEqualTo(expectedState)
    }

    companion object HomeTest {
        @JvmStatic
        fun home(): List<Any> {
            return listOf(
                    Arguments { arrayOf(NewRecord(RecordType.FUEL), Actions.Common.OpenMenu, MenuOpened(NewRecord(RecordType.FUEL))) },
                    Arguments { arrayOf(NewRecord(RecordType.FUEL), Actions.Common.CloseMenu, MenuClosed(NewRecord(RecordType.FUEL))) },
                    Arguments { arrayOf(NewRecord(RecordType.FUEL), Actions.Common.Back, Home) },
                    Arguments { arrayOf(NewRecord(RecordType.FUEL), Actions.Menu.Garage, Garage()) },
                    Arguments { arrayOf(NewRecord(RecordType.FUEL), Actions.Menu.Home, Home) },
                    Arguments { arrayOf(NewRecord(RecordType.FUEL), Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Common.OpenMenu, MenuOpened(RecordTypeChoice)) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Common.CloseMenu, MenuClosed(RecordTypeChoice)) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Common.Back, Home) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Menu.Garage, Garage()) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Menu.Home, Home) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Home.RecordTypeChoice(RecordType.SERVICE), NewRecord(RecordType.SERVICE)) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Home.RecordTypeChoice(RecordType.FUEL), NewRecord(RecordType.FUEL)) },
                    Arguments { arrayOf(RecordTypeChoice, Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(Home, Actions.Common.OpenMenu, MenuOpened(Home)) },
                    Arguments { arrayOf(Home, Actions.Common.CloseMenu, MenuClosed(Home)) },
                    Arguments { arrayOf(Home, Actions.Common.Back, AppClosed) },
                    Arguments { arrayOf(Home, Actions.Menu.Home, Home) },
                    Arguments { arrayOf(Home, Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(Home, Actions.Menu.Garage, Garage()) },
                    Arguments { arrayOf(Home, Actions.Home.AddNewRecord, RecordTypeChoice) }
            )
        }

        @JvmStatic
        fun garage(): List<Any> {
            return listOf(
                    Arguments { arrayOf(VehicleDetails(1), Actions.Common.OpenMenu, MenuOpened(VehicleDetails(1))) },
                    Arguments { arrayOf(VehicleDetails(1), Actions.Common.CloseMenu, MenuClosed(VehicleDetails(1))) },
                    Arguments { arrayOf(VehicleDetails(1), Actions.Common.Back, Garage()) },
                    Arguments { arrayOf(VehicleDetails(1), Actions.Menu.Garage, Garage()) },
                    Arguments { arrayOf(VehicleDetails(1), Actions.Menu.Home, Home) },
                    Arguments { arrayOf(VehicleDetails(1), Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(Garage(true), Actions.Common.OpenMenu, MenuOpened(Garage(true))) },
                    Arguments { arrayOf(Garage(true), Actions.Common.Back, Home) },
                    Arguments { arrayOf(Garage(true), Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(Garage(true), Actions.Garage.Empty, Garage(true)) },
                    Arguments { arrayOf(Garage(true), Actions.Menu.Garage, Garage(true)) },
                    Arguments { arrayOf(Garage(true), Actions.Menu.Home, Home) },
                    Arguments { arrayOf(Garage(true), Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(Garage(true), Actions.Menu.Garage, Garage(true)) },
                    Arguments { arrayOf(NewVehicle, Actions.Common.Back, Garage()) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.FinishCreate, NewVehicleCreated) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.Cancel, Garage()) },
                    Arguments { arrayOf(NewVehicle, Actions.Home.AddNewRecord, NewVehicle) },
                    Arguments { arrayOf(SignOut, Actions.Common.Back, SignOut) },
                    Arguments { arrayOf(AppClosed, Actions.Home.AddNewRecord, AppClosed) },
                    Arguments { arrayOf(Garage(), Actions.Common.OpenMenu, MenuOpened(Garage())) },
                    Arguments { arrayOf(Garage(), Actions.Common.CloseMenu, MenuClosed(Garage())) },
                    Arguments { arrayOf(Garage(), Actions.Common.Back, Home) },
                    Arguments { arrayOf(Garage(), Actions.Menu.Home, Home) },
                    Arguments { arrayOf(Garage(), Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(Garage(), Actions.Menu.Garage, Garage()) },
                    Arguments { arrayOf(Garage(), Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(Garage(), Actions.Garage.Empty, Garage(true)) },
                    Arguments { arrayOf(Garage(), Actions.Home.AddNewRecord, Garage()) }
            )
        }
    }
}