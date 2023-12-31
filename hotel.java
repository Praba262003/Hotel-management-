<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE xml>
<odoo>

    <menuitem id="menu_hotel_reporting" name="Reports" parent="hotel.hotel_management_menu" sequence="7"/>

    <!-- Action of hotel reservation -->
    <record id="action_view_frontdesk_cal" model="ir.actions.act_window">
        <field name="name">FrontDesk</field>
        <field name="res_model">hotel.reservation</field>
        <field name="view_type">form</field>
        <field name="view_mode">calendar,form</field>
        <field name="view_id" ref="hotel_reservation.hotel_calendar_view" />
    </record>

    <!-- Action of hotel restaurant kitchen order tickets -->
    <record id="action_hotel_restaurant_order_board" model="ir.actions.act_window">
        <field name="name">Current Orders Details</field>
        <field name="res_model">hotel.restaurant.kitchen.order.tickets</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree</field>
        <field name="context">{'tree_view_ref':'hotel_restaurant.view_hotel_restaurant_kitchen_order_tickets_tree','search_default_today':1}
        </field>
    </record>

    <!-- Action for room reservation summary -->
    <record id="action_desk_hotel_reservation_summary" model="ir.actions.act_window">
        <field name="name">action.desk.hotel.reservation.summary</field>
        <field name="type">ir.actions.act_window</field>
        <field name="res_model">room.reservation.summary</field>
        <field name="view_type">form</field>
        <field name="view_mode">form</field>
    </record>

    <!-- Tree view of Current Table Reservation -->
    <record id="view_board_hotel_restaurant_reservation_tree" model="ir.ui.view">
        <field name="name">view.board.hotel.restaurant.reservation.tree</field>
        <field name="model">hotel.restaurant.reservation</field>
        <field name="arch" type="xml">
            <tree string="Table Reservation">
                <field name="tableno" />
                <field name="cname" />
                <field name="start_date" />
                <field name="end_date" />
            </tree>
        </field>
    </record>

    <!-- Action of Current Table Reservation -->
    <record id="action_table_order_board" model="ir.actions.act_window">
        <field name="name">Current Table Reservation Details</field>
        <field name="res_model">hotel.restaurant.reservation</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
        <field name="view_id" ref="view_board_hotel_restaurant_reservation_tree" />
        <field name="domain">[('state','in',('order','done')),('start_date','&lt;=',datetime.datetime.now()),('end_date','&gt;',datetime.datetime.now())]
        </field>
    </record>

    <!-- Action of hotel room -->
    <record id="action_hotel_room_board" model="ir.actions.act_window">
        <field name="name">Hotel Rooms Details</field>
        <field name="res_model">hotel.room</field>
        <field name="view_type">form</field>
        <field name="view_mode">kanban</field>
        <field name="context">{'kanban_view_ref':'hotel.view_hotel_room_kanban'}
        </field>
    </record>

    <!-- Form view of board -->
    <record id="board_frontdesk_form" model="ir.ui.view">
        <field name="name">board.frontdesk.form</field>
        <field name="model">board.board</field>
        <field name="type">form</field>
        <field name="arch" type="xml">
            <form string="FrontDesk board">
                <h2>Hotel FrontDesk Board</h2>
                <hpaned>
                    <child1>
                        <action string="Reservation" name="%(action_view_frontdesk_cal)d" />
                        <action string="Reservation Summary" name="%(action_desk_hotel_reservation_summary)d" />
                        <action string="Rooms Details" name="%(action_hotel_room_board)d" />
                        <action string="Today's Restaurant Orders" name="%(action_hotel_restaurant_order_board)d" />
                        <action string="Currently Reserved Tables Details" name="%(action_table_order_board)d" />
                    </child1>
                </hpaned>
            </form>
        </field>
    </record>

    <!-- Action of board -->
    <record id="open_board_frontdesk" model="ir.actions.act_window">
        <field name="name">FrontDesk Dashboard</field>
        <field name="res_model">board.board</field>
        <field name="view_type">form</field>
        <field name="view_mode">form</field>
        <field name="usage">menu</field>
        <field name="view_id" ref="board_frontdesk_form" />
    </record>

    <menuitem name="Hotel FrontDesk Board" action="open_board_frontdesk" sequence="1" id="menu_board_frontdesk" icon="terp-graph" parent="menu_hotel_reporting" />

    <!-- Action for report hotel reservation status -->
    <record id="action_report_hotel_reservation_status_tree_graph_bar12" model="ir.actions.act_window">
        <field name="name">States By Reservation</field>
        <field name="res_model">report.hotel.reservation.status</field>
        <field name="view_type">form</field>
        <field name="view_mode">pivot,graph,tree</field>
        <field name="context">{'graph_view_ref':'report_hotel_reservation.view_hotel_reservation_status_graph_bar','tree_view_ref':'report_hotel_reservation.view_hotel_reservation_status_tree'}
        </field>
    </record>

    <menuitem name="States By Reservation" action="action_report_hotel_reservation_status_tree_graph_bar12" id="menu_hotel_reservation_status_tree_graph_bar11" sequence="34" parent="menu_hotel_reporting" />

    <!-- Action for report hotel restaurant status -->
    <record id="action_report_hotel_restaurant_board" model="ir.actions.act_window">
        <field name="name">States By Restaurants</field>
        <field name="res_model">report.hotel.restaurant.status</field>
        <field name="view_type">form</field>
        <field name="view_mode">pivot,graph,tree</field>
        <field name="context">{'graph_view_ref':'report_hotel_restaurant.view_hotel_restaurant_status_graph_bar','tree_view_ref':'report_hotel_restaurant.view_hotel_restaurant_status_tree'}
        </field>
    </record>

    <menuitem name="States By Restaurant" action="action_report_hotel_restaurant_board" id="menu_action_report_hotel_restaurant_board" sequence="35" parent="menu_hotel_reporting" />

</odoo