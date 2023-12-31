<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE xml>
<odoo>

    <menuitem id="hotel_management_menu" name="Hotel Management" />

    <menuitem id="hotel_configuration_menu" name="Configuration"
        sequence="20" parent="hotel_management_menu" />
    <menuitem id="hotel_report_menu" name="Pdf Reports" sequence="6"
        parent="hotel_management_menu" />

    <record id="view_product_product_form_inherited" model="ir.ui.view">
        <field name="name">view.product.product.form.inherited</field>
        <field name="model">product.product</field>
        <field name="inherit_id" ref="product.product_normal_form_view" />
        <field name="arch" type="xml">
            <xpath expr="//field[@name='active']" position="after">
                <field name="isroom" />
            </xpath>
        </field>
    </record>

    <!-- ====== Company Configuration ====== -->
    <record id="res_company_inherit_config_hotel" model="ir.ui.view">
        <field name="name">res.company.inherit.config.hotel</field>
        <field name="model">res.company</field>
        <field name="inherit_id" ref="base.view_company_form" />
        <field name="arch" type="xml">
            <xpath expr="//field[@name='currency_id']" position="after">
                <field name="additional_hours" />
            </xpath>
        </field>
    </record>

    <!--======== Floor ======== -->
    <!-- Form view of hotel floor -->
    <record id="view_hotel_floor_form" model="ir.ui.view">
        <field name="name">hotel.floor.form</field>
        <field name="model">hotel.floor</field>
        <field name="arch" type="xml">
            <form string=" Hotel Floor">
                <sheet>
                    <group>
                        <field name="name" colspan="1" />
                        <field name="sequence" invisible="1" />
                    </group>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Tree view of hotel floor -->
    <record id="view_hotel_floor_tree" model="ir.ui.view">
        <field name="name">hotel.floor.tree</field>
        <field name="model">hotel.floor</field>
        <field name="arch" type="xml">
            <tree string=" Hotel Floors">
                <field name="sequence" widget="handle" />
                <field name="name" colspan="1" />
            </tree>
        </field>
    </record>

    <!-- Action of hotel floor -->
    <record id="open_hotel_floor_form_tree" model="ir.actions.act_window">
        <field name="name">Floor</field>
        <field name="res_model">hotel.floor</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
    </record>

    <menuitem id="menu_open_hotel_floor_form_tree" name="Floor"
        action="open_hotel_floor_form_tree" sequence="21"
        parent="hotel_configuration_menu" />

    <!--======= Room Type ======= -->
    <!-- Form view of hotel room type -->
    <record id="view_hotel_room_type_form" model="ir.ui.view">
        <field name="name">hotel.room_type.form</field>
        <field name="model">hotel.room.type</field>
        <field name="arch" type="xml">
            <form string=" Hotel Room Type">
                <sheet>
                    <group>
                        <field name="name" />
                        <field name="categ_id" select="1" />
                        <field name="child_id" invisible="1" />
                    </group>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Tree view of hotel room type -->
    <record id="view_hotel_room_type_tree" model="ir.ui.view">
        <field name="name">hotel.room_type.tree</field>
        <field name="model">hotel.room.type</field>
        <field name="arch" type="xml">
            <tree string="Hotel Room Type">
                <field name="name" />
            </tree>
        </field>
    </record>

    <!-- Action for hotel room type -->
    <record id="open_hotel_room_type_form_tree" model="ir.actions.act_window">
        <field name="name">Room Type</field>
        <field name="res_model">hotel.room.type</field>
        <field name="view_type">form</field>
        <field name="context">{}</field>
        <field name="view_mode">tree,form</field>
    </record>
    <menuitem id="menu_hotel_room" name="Room"
        parent="hotel.hotel_configuration_menu" sequence="2" />
    <menuitem id="menu_open_hotel_room_type_form_tree" name="Room Types"
        action="open_hotel_room_type_form_tree" sequence="6"
        parent="hotel.menu_hotel_room" />

    <!--==== Amenities Type ==== -->
    <!-- Form view of hotel room amenities type -->
    <record id="view_hotel_room_amenities_type_form" model="ir.ui.view">
        <field name="name">hotel.room_amenities_type_form</field>
        <field name="model">hotel.room.amenities.type</field>
        <field name="arch" type="xml">
            <form string="Hotel Room Amenities Type">
                <sheet>
                    <group>
                        <field name="name" string="Amenity Type" />
                        <field name="amenity_id" />
                        <field name="child_id" invisible="1" />
                    </group>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Tree view of hotel room amenities type -->
    <record id="view_hotel_room_amenities_type_list" model="ir.ui.view">
        <field name="name">hotel.room_amenities_type_list</field>
        <field name="model">hotel.room.amenities.type</field>
        <field name="arch" type="xml">
            <tree string="Hotel Room Amenities Type">
                <field name="name" />
            </tree>
        </field>
    </record>

    <!-- Action for hotel room amenities type -->
    <record id="action_hotel_room_amenities_type_view_form" model="ir.actions.act_window">
        <field name="name">Amenities Type</field>
        <field name="res_model">hotel.room.amenities.type</field>
        <field name="context">{'default_isamenitytype':1}</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
    </record>

    <menuitem id="menu_amenity" name="Amenity"
        parent="hotel.hotel_configuration_menu" sequence="2" />
    <menuitem name="Amenity Types"
        id="menu_action_hotel_room_amenities_type_view_form" action="action_hotel_room_amenities_type_view_form"
        sequence="3" parent="hotel.menu_amenity" />

    <!--===== Room Amenities ===== -->
    <!-- Form view of hotel room amenities -->
    <record id="view_hotel_room_amenities_form" model="ir.ui.view">
        <field name="name">hotel.room.amenities.form</field>
        <field name="model">hotel.room.amenities</field>
        <field name="arch" type="xml">
            <form string="Hotel Room Amenities">
                <sheet>
                    <h1>
                        <field name="name" />
                    </h1>
                    <group>
                        <field name="default_code" />
                    </group>
                    <notebook>
                        <page string="Information">
                            <group colspan="4" col="4">
                                <field name="type" select="2" string="Amenity Type" />
                                <field name="categ_id" string="Amenities Category" />
                                <field name="product_manager" select="2" string="Amenity manager" />
                                <field name="uom_id" />
                                <field name="uom_po_id" />
                            </group>
                            <newline />
                            <separator colspan='4' string="Supplier Taxes" />
                            <field name="supplier_taxes_id" colspan="4" nolabel='1'
                                help='Define supplier taxes if there any on the ty. ' />
                            <newline />
                            <separator colspan='4' string="Customer Taxes" />
                            <field name="taxes_id" colspan="4" nolabel='1'
                                help='List of customer taxes applied on the ty. ' />
                        </page>
                        <page string="Procurement">
                            <group colspan="4" col="4">
                                <field name="active" select="2" />
                                <field name="list_price" />
                                <field name="cost_method" string="Cost Method" />
                                <field name="sale_ok" select="2" />
                                <field name="standard_price" />
                                <field name="rental" select="2" />
                            </group>
                            <newline />
                            <group>
                                <separator string="Suppliers" />
                                <field name="seller_ids" colspan="4" nolabel="1"
                                    widget="one2many_list" />
                            </group>
                        </page>
                        <page string="Descriptions">
                            <separator string="Description" />
                            <field name="description" colspan="4" nolabel="1" />
                            <separator string="Sale Description" />
                            <field name="description_sale" colspan="4" nolabel="1" />
                            <separator string="Purchase Description" />
                            <field name="description_purchase" colspan="4" nolabel="1" />
                        </page>
                    </notebook>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Search view of hotel room amenities -->
    <record id="view_hotel_room_aenities_search" model="ir.ui.view">
        <field name="name">hotel.room_amenities_search</field>
        <field name="model">hotel.room.amenities</field>
        <field name="arch" type="xml">
            <search string="Hotel Room Amenities">
                <field name="name" />
                <field name="categ_id" />
                <field name="list_price" string="ty rate" />
                <newline />
                <group expand="0" string="Group By...">
                    <filter name="categ_id" string="Catagory" icon="terp-stock_symbol-selection"
                        domain="[]" context="{'group_by':'categ_id'}" />
                </group>
            </search>
        </field>
    </record>

    <!-- Tree view of hotel room amenities -->
    <record id="view_hotel_room_amenities_list" model="ir.ui.view">
        <field name="name">hotel.room_amenities_list</field>
        <field name="model">hotel.room.amenities</field>
        <field name="arch" type="xml">
            <tree string="Hotel Room Amenities">
                <field name="name" />
                <field name="categ_id" />
                <field name="list_price" string="Amenity Rate" invisible="1" />
            </tree>
        </field>
    </record>

    <!-- Action for hotel room amenities -->
    <record id="action_hotel_room_amenities_view_form" model="ir.actions.act_window">
        <field name="name">Amenities</field>
        <field name="res_model">hotel.room.amenities</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
        <field name="context">{'default_iscategid':1,'default_available_in_pos':0}
        </field>
        <field name="view_id" ref="view_hotel_room_amenities_list" />
    </record>
    <menuitem id="menu_action_hotel_room_amenities_view_form"
        name="Amenities" action="action_hotel_room_amenities_view_form"
        sequence="2" parent="hotel.menu_amenity" />

    <!-- Hierarchical Tree view of Amenity Category -->
    <record id="hotel_amenities_category_tree_view" model="ir.ui.view">
        <field name="name">hotel.room.amenities.type.tree</field>
        <field name="model">hotel.room.amenities.type</field>
        <field name="field_parent">child_id</field>
        <field name="arch" type="xml">
            <tree toolbar="True" string="Amenities Categories">
                <field name="name" />
            </tree>
        </field>
    </record>

    <record id="action_hotel_amenities" model="ir.actions.act_window">
        <field name="name">Amenities</field>
        <field name="res_model">hotel.room.amenities</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
        <field name="domain">[('iscategid' , '=', True)]</field>
        <field name="context">{'search_default_product_id':active_id,'default_product_id':active_id}</field>
    </record>

    <!-- Binding Tree Click to Action -->
    <record id="ir_hotel_amenities_open" model="ir.values">
        <field eval="'tree_but_open'" name="key2" />
        <field eval="'hotel.room.amenities.type'" name="model" />
        <field name="name">Amenities by Category</field>
        <field eval="'ir.actions.act_window,%d'%action_hotel_amenities"
            name="value" />
    </record>

    <record id="hotel_amenities_category_action" model="ir.actions.act_window">
        <field name="name">Amenities by Category</field>
        <field name="type">ir.actions.act_window</field>
        <field name="res_model">hotel.room.amenities.type</field>
        <field name="domain">[('amenity_id', '=', False)]</field>
        <field name="view_type">tree</field>
        <field name="view_id" ref="hotel_amenities_category_tree_view" />
    </record>

    <menuitem name="Amenities by Category" id="menu_hotel_ty_category_action"
        action="hotel_amenities_category_action" sequence="4" parent="hotel.menu_amenity" />

    <!-- ====== Rooms ====== -->
    <!-- Form view of hotel room -->
    <record id="view_hotel_room_form" model="ir.ui.view">
        <field name="name">hotel.room.form</field>
        <field name="model">hotel.room</field>
        <field name="arch" type="xml">
            <form string="Hotel Room">
                <sheet>
                    <field name="image_medium" widget="image" class="oe_avatar" />
                    <div class="oe_title">
                        <label for="name" string="Name" />
                        <h1>
                            <field name="name" />
                        </h1>
                        <label for="status" string="Status" />
                        <h2>
                            <field name="status" readonly="1" />
                        </h2>
                        <h2>
                            <field name="isroom" />
                        </h2>
                    </div>
                    <notebook>
                        <page name="information_hotel_room" string="Information">
                            <group colspan="4" col="4">
                                <field name="floor_id" string="Floor" />
                                <field name="categ_id" select="1" />
                                <field name="product_manager" select="2" string="Room Manager" />
                                <field name="capacity" />
                                <field name="uom_id" invisible="1" />
                            </group>
                            <newline />
                            <separator colspan='4' string="Supplier Taxes" />
                            <field name="supplier_taxes_id" colspan="4" nolabel='1'
                                help='List of supplier taxes if there any on the defined room. ' />
                            <newline />
                            <separator colspan='4' string="Customer Taxes" />
                            <field name="taxes_id" colspan="4" nolabel='1'
                                help='Customer taxes apply on the perticular room. ' />
                        </page>
                        <page string="Room Amenities">
                            <separator string=" Room Amenities" />
                            <field name="room_amenities" colspan="4" nolabel="1" />
                        </page>
                        <page string="Procurement">
                            <group colspan="4" col="4">
                                <field name="active" select="2" />
                                <field name="list_price" />
                                <field name="rental" select="2" />
                                <field name="standard_price" />
                                <field name="cost_method" string="Cost Method" />
                                <newline />
                            </group>
                            <newline />
                            <group>
                                <separator string="Suppliers" />
                                <field name="seller_ids" colspan="4" nolabel="1"
                                    widget="one2many_list" />
                            </group>
                        </page>
                        <page string="Descriptions">
                            <separator string="Description" />
                            <field name="description" colspan="4" nolabel="1" />
                        </page>
                        <page string="Folio Room Reservations">
                            <separator colspan='4' string="Folio Room Reservation Line" />
                            <field name="room_line_ids" colspan="4" nolabel='1'>
                                <form string=" Room line">
                                    <group colspan='4' col='4'>
                                        <field name="room_id" />
                                        <field name="check_in" />
                                        <field name="check_out" />
                                        <field name="folio_id" />
                                        <field name="status" />
                                    </group>
                                </form>
                                <tree>
                                    <field name="room_id" />
                                    <field name="check_in" />
                                    <field name="check_out" />
                                    <field name="folio_id" />
                                    <field name="status" />
                                </tree>
                            </field>
                        </page>
                    </notebook>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Search view of hotel room -->
    <record id="view_hotel_room_search" model="ir.ui.view">
        <field name="name">hotel.room.search</field>
        <field name="model">hotel.room</field>
        <field name="arch" type="xml">
            <search string="Hotel Room">
                <field name="name" />
                <field name="categ_id" />
                <field name="list_price" string="Room rate" />
                <field name="status" string="Status" />
                <newline />
                <filter name="available" string="Available"
                    domain="[('status','=', 'available')]" help="Available Rooms" />
                <filter string="Reserved" domain="[('status','=', 'occupied')]"
                    help="Reserved Rooms" />
            </search>
        </field>
    </record>

    <!-- Tree view of hotel room -->
    <record id="view_hotel_room_tree" model="ir.ui.view">
        <field name="name">hotel.room.tree</field>
        <field name="model">hotel.room</field>
        <field name="arch" type="xml">
            <tree string="Hotel Room">
                <field name="name" />
                <field name="categ_id" />
                <field name="list_price" string="Room rate" />
                <field name="status" />
                <field name="capacity" />
            </tree>
        </field>
    </record>

    <record id="view_hotel_room_kanban" model="ir.ui.view">
        <field name="name">hotel.room.kanban</field>
        <field name="model">hotel.room</field>
        <field name="arch" type="xml">
            <kanban default_group_by="status">
                <field name="name" />
                <field name="status" />
                <field name="color" />
                <field name="lst_price" />
                <templates>
                    <t t-name="kanban-box">
                        <div
                            t-attf-class="oe_kanban_color_#{kanban_getcolor(record.color.raw_value)} oe_kanban_card oe_kanban_global_click">
                            <div class="o_dropdown_kanban dropdown" groups="base.group_user">
                                <a class="dropdown-toggle btn" data-toggle="dropdown" href="#">
                                    <span class="fa fa-bars fa-lg" />
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                    <t t-if="widget.editable">
                                        <li>
                                            <a type="edit">Edit</a>
                                        </li>
                                    </t>
                                    <t t-if="widget.deletable">
                                        <li>
                                            <a type="delete">Delete</a>
                                        </li>
                                    </t>
                                    <li>
                                        <ul class="oe_kanban_colorpicker" data-field="color" />
                                    </li>
                                </ul>
                            </div>
                            <div class="oe_kanban_details" style='margin-top: -5px;'>
                                <div class="oe_kanban_content">
                                    <div class="oe_kanban_project_list">
                                        <H3>
                                            <a type="open">
                                                <img
                                                    t-att-src="kanban_image('hotel.room', 'image_medium', record.id.value)"
                                                    style="height:70px;width:70px" class="oe_avatar oe_kanban_avatar_smallbox" />
                                                <t t-if="record.code.raw_value" style="margin-right: 10px">
                                                    [
                                                    <field name="code" />
                                                    ]
                                                </t>
                                                <field name="name" />
                                            </a>
                                        </H3>
                                    </div>
                                    <div name="tags" />
                                    <ul>
                                        <li>
                                            Status:
                                            <field name="status"></field>
                                        </li>
                                        <li>
                                            Rate:
                                            <field name="lst_price"></field>
                                        </li>
                                        <li>
                                            Capacity:
                                            <field name="capacity"></field>
                                        </li>
                                    </ul>
                                </div>
                                <div class="oe_kanban_bottom_right">
                                    <a t-if="record.status.raw_value === 'available'" type="object"
                                        string="Available" name="set_room_status_occupied"
                                        class="oe_kanban_status oe_kanban_status_green ">
                                    </a>
                                    <a t-if="record.status.raw_value === 'occupied'" type="object"
                                        string="occupied" name="set_room_status_available"
                                        class="oe_kanban_status oe_kanban_status_red ">
                                    </a>
                                </div>
                            </div>
                            <div class="oe_clear"></div>
                        </div>
                    </t>
                </templates>
            </kanban>
        </field>
    </record>

    <!-- Action for hotel room -->
    <record id="action_hotel_room_form" model="ir.actions.act_window">
        <field name="name">Room</field>
        <field name="res_model">hotel.room</field>
        <field name="view_type">form</field>
        <field name="context">{'default_isroom':1,'default_rental':1,'default_available_in_pos':0}
        </field>
        <field name="view_id" ref="view_hotel_room_tree" />
        <field name="view_mode">kanban,tree,form</field>
    </record>

    <menuitem id="menu_open_hotel_room_form" name="Rooms"
        action="action_hotel_room_form" sequence="5" parent="hotel.menu_hotel_room" />

    <record id="hotel_room_category_tree_view" model="ir.ui.view">
        <field name="name">hotel.room.type.tree</field>
        <field name="model">hotel.room.type</field>
        <field name="field_parent">child_id</field>
        <field name="arch" type="xml">
            <tree toolbar="True" string="Room Categories">
                <field name="name" />
            </tree>
        </field>
    </record>

    <record id="action_hotel_room" model="ir.actions.act_window">
        <field name="name">Room</field>
        <field name="res_model">hotel.room</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
        <field name="domain">[('isroom','=',True)]</field>
        <field name="context">{'search_default_product_id':active_id,'default_product_id':active_id}</field>
    </record>

    <!-- Binding Tree Click to Action -->
    <record id="ir_hotel_room_open" model="ir.values">
        <field eval="'tree_but_open'" name="key2" />
        <field eval="'hotel.room.type'" name="model" />
        <field name="name">Rooms by Category</field>
        <field eval="'ir.actions.act_window,%d'%action_hotel_room" name="value" />
    </record>

    <record id="hotel_room_category_action" model="ir.actions.act_window">
        <field name="name">Rooms by Category</field>
        <field name="type">ir.actions.act_window</field>
        <field name="res_model">hotel.room.type</field>
        <field name="domain">[('categ_id','=',False)]</field>
        <field name="view_type">tree</field>
        <field name="view_id" ref="hotel_room_category_tree_view" />
    </record>

    <menuitem name="Room by Category" id="menu_hotel_room_category_action"
        action="hotel_room_category_action" sequence="7" parent="hotel.menu_hotel_room" />

    <!--=== Hotel Folio ==== -->
    <!-- Form view of hotel folio -->
    <record id="view_hotel_folio1_form" model="ir.ui.view">
        <field name="name">hotel.folio.form</field>
        <field name="model">hotel.folio</field>
        <field name="arch" type="xml">
            <form string="Folio">
                <header>
                    <button name="action_confirm" states="draft" string="Confirm Sale"
                        class="btn-primary" type="object" />
                    <button name="%(sale.action_view_sale_advance_payment_inv)d"
                        string="Create Invoice" type="action" class="btn-primary"
                        attrs="{'invisible': ['|',('state', 'in', ('draft','cancel','done')), ('invoice_status', 'in', 'invoiced')]}" />
                    <button name="action_cancel_draft" states="cancel" string="Set to Draft"
                        type="object" icon="fa-check-square-o" class="oe_highlight" />
                    <button name="action_cancel" string="Cancel Folio" states="sale"
                        type="object" icon="fa-close" class="oe_highlight" />
                    <button name="action_cancel" string="Cancel Folio" states="draft"
                        icon="fa-close" type="object" class="oe_highlight" />
                    <button name="action_done" type="object" string="Set to Done"
                        states="sale" class="oe_highlight"
                        help="If a Hotel Folio is done, you cannot modify it manually anymore. However, you will still be able to invoice or deliver. This is used to freeze the Hotel Folio." />
                    <field name="state" select="2" widget="statusbar"
                        statusbar_visible="draft,sent,sale,done" />
                </header>
                <sheet>
                    <div class="oe_right oe_button_box">
                        <button name="go_to_currency_exchange" string="Money Exchange"
                            icon="fa-refresh" class="oe_stat_button" type="object" />
                    </div>
                    <label string="Folio Number" />
                    <h1>
                        <field name="name" colspan="4" />
                    </h1>
                    <group colspan="4" col="4">
                        <field name="date_order" />
                        <field name="warehouse_id" string="Branch" />
                        <field name="invoice_status" />
                        <field name="hotel_invoice_id" states='sale,done,cancel'
                            readonly="1" />
                    </group>
                    <notebook colspan="4">
                        <page string="Folio">
                            <group colspan="4" col="4">
                                <field name="partner_id" string="Guest Name" required="1" />
                                <field name="partner_invoice_id" domain="[('parent_id','=',partner_id)]" />
                                <field name="pricelist_id" />
                                <field name="project_id" />
                                <field name="partner_shipping_id" domain="[('parent_id','=',partner_id)]" />
                            </group>
                            <newline />
                            <group colspan="4" col="4">
                                <field name="checkin_date" />
                                <field name="checkout_date" />
                                <field name="duration" readonly="1" />
                                <field name="duration_dummy" invisible="1" />
                            </group>
                            <separator string="Room Lines" colspan="4" />
                            <field name="room_lines" colspan="4" string="Room Line"
                                nolabel="1"
                                context="{'checkin':checkin_date,'checkout':checkout_date,'folio':context.get('folio')}">
                                <form string="Room Line">
                                    <notebook>
                                        <page string="Folio Line">
                                            <group col="6" colspan="4">
                                                <field name="checkin_date" />
                                                <field name="checkout_date" />
                                                <separator string="Automatic Declaration" col="6"
                                                    colspan="4" />
                                                <field name="product_uom_qty"
                                                    context="{'partner_id':parent.partner_id,'quantity':product_uom_qty,'pricelist':parent.pricelist_id,'uom':product_uom}"
                                                    invisible="1" />
                                                <field name="product_id"
                                                    context="{'partner_id':parent.partner_id,'quantity':product_uom_qty,'pricelist':parent.pricelist_id,'uom':product_uom}"
                                                    domain="[('isroom','=',True)]" string="Room No" />
                                                <field name="product_uom" string="Rent(UOM)" />
                                            </group>
                                            <separator string="Manual Description" colspan="4" />
                                            <field name="name" colspan="4" select="2"
                                                placeholder="---Description---" />
                                            <group col="4" colspan="2">
                                                <field name="price_unit" select="2" string="Rent" />
                                                <field name="discount" />
                                                <newline />
                                                <field name="tax_id" colspan="4" nolabel="1" />
                                                <separator string="States" colspan="4" />
                                                <field name="state" select="2" />
                                                <field name="invoice_status" />
                                            </group>
                                        </page>

                                        <page string="History">
                                            <separator string="Invoice Lines" colspan="4" />
                                            <field name="invoice_lines" colspan="4" nolabel="1"
                                                readonly="1" />
                                        </page>
                                    </notebook>
                                </form>
                                <tree string="Room Line">
                                    <field name="name" />
                                    <field name="checkin_date" />
                                    <field name="checkout_date" />
                                    <field name="product_id" string="Room No" />
                                    <field name="product_uom" string="Rent(UOM)" />
                                    <field name="price_unit" string="Rent" />
                                    <field name="price_subtotal" />
                                    <field name="state" />
                                </tree>
                            </field>
                            <separator string="Service Lines" colspan="4" />
                            <field name="service_lines" colspan="4" string="Service Line"
                                nolabel="1" context="{'checkin':checkin_date,'checkout':checkout_date}">
                                <form string="Service Line">
                                    <notebook>
                                        <page string="Service Line">
                                            <group col="4" colspan="4">
                                                <field name="ser_checkin_date" />
                                                <field name="ser_checkout_date" />
                                            </group>
                                            <separator string="Automatic Declaration" col="4"
                                                colspan="4" />
                                            <group col="4" colspan="4">
                                                <field name="product_id" domain="[('isservice','=',True)]"
                                                    context="{'partner_id':parent.partner_id,'quantity':product_uom_qty,'pricelist':parent.pricelist_id,'hotel':parent.warehouse_id,'uom':product_uom}" />
                                                <field name="product_uom" />
                                                <field name="product_uom_qty"
                                                    context="{'partner_id':parent.partner_id,'quantity':product_uom_qty,'pricelist':parent.pricelist_id,'hotel':parent.warehouse_id,'uom':product_uom}"
                                                    invisible="1" />
                                            </group>
                                            <separator string="Manual Description" colspan="4" />
                                            <field name="name" colspan="4" select="2"
                                                placeholder="---Description---" />
                                            <group>
                                                <field name="price_unit" select="2" />
                                                <field name="discount" />
                                            </group>
                                            <newline />
                                            <field name="tax_id" colspan="4" />
                                            <group>
                                                <separator string="States" colspan="4" />
                                                <field name="state" select="2" />
                                                <field name="invoice_status" />
                                            </group>
                                        </page>

                                        <page string="History">
                                            <separator string="Invoice Lines" colspan="4" />
                                            <field name="invoice_lines" colspan="4" nolabel="1"
                                                readonly="1" />
                                        </page>
                                    </notebook>
                                </form>
                                <tree string="Service Line">
                                    <field name="name" />
                                    <field name="product_id" />
                                    <field name="product_uom_qty" />
                                    <field name="price_unit" />
                                    <field name="price_subtotal" />
                                    <field name="state" />
                                </tree>
                            </field>
                            <group colspan="2" class="oe_subtotal_footer oe_right">
                                <field name="amount_untaxed" sum="Untaxed amount" widget='monetary' />
                                <field name="amount_tax" widget='monetary' />
                                <div class="oe_subtotal_footer_separator oe_inline">
                                    <label for="amount_total" />
                                </div>
                                <field name="amount_total" nolabel="1" sum="Total amount"
                                    widget='monetary' />
                                <button name="button_dummy" string="Compute" states="draft"
                                    type="object" class="fa fa-calculator" aria-hidden="true"
                                    style="background-color:#7c7bad;" />
                            </group>
                            <div class="oe_clear" />
                        </page>
                        <page string="Other data">
                            <group>
                                <field name="user_id" />
                                <field name="hotel_policy" attrs="{'readonly':[('state','not in',('draft'))]}" />
                                <field name="client_order_ref" />
                            </group>
                        </page>
                        <page string="History">
                            <separator string="Related invoices" colspan="4" />
                            <field name="invoice_ids" colspan="4" nolabel="1" />
                        </page>
                        <page string="Foreign Exchange" name="foreign exchange">
                            <separator string="Foreign Exchange" colspan="4" />
                            <field name="currrency_ids" colspan="4" nolabel="1">
                                <tree>
                                    <field name="name" />
                                    <field name="today_date" />
                                    <field name="type" />
                                    <field name="in_amount" />
                                    <field name="input_curr" />
                                    <field name="total" sum="Total Amount" />
                                    <field name="out_curr" />
                                </tree>
                            </field>
                        </page>
                    </notebook>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Tree view of hotel folio -->
    <record id="view_hotel_folio1_tree" model="ir.ui.view">
        <field name="name">hotel.folio.tree</field>
        <field name="model">hotel.folio</field>
        <field name="arch" type="xml">
            <tree string="Hotel Folio" colors="blue:state == 'draft';gray:state == 'done'">
                <field name="checkin_date" />
                <field name="checkout_date" />
                <field name="name" />
                <field name="partner_id" />
                <field name="date_order" />
                <field name="state" />
                <field name="amount_total" sum="Total amount" />
            </tree>
        </field>
    </record>

    <!-- Calendar view of hotel folio -->
    <record id="hotel_folio_calendar_view" model="ir.ui.view">
        <field name="name">Hotel- Folios Calendar</field>
        <field name="model">hotel.folio</field>
        <field name="arch" type="xml">
            <calendar string="Folios" date_start="checkin_date" color="user_id"
                date_stop="checkout_date">
                <field name="name" />
                <field name="partner_id" />
                <field name="duration" />
            </calendar>
        </field>
    </record>

    <!-- Search view of hotel folio -->
    <record id="view_hotel_folio_search" model="ir.ui.view">
        <field name="name">hotel.folio.search</field>
        <field name="model">hotel.folio</field>
        <field name="arch" type="xml">
            <search string="Tables Detail">
                <field name="partner_id" />
                <field name="name" />
                <filter string="Current Booking"
                    domain="[('checkout_date','&gt;=',datetime.datetime.now().replace(hour=0, minute=0, second=0)),('checkin_date','&lt;=',datetime.datetime.now().replace(hour=23, minute=59, second=59))]"
                    help="Current Booking" />
                <group expand="0" string="Group By">
                    <filter string="Order By Month" domain="[]"
                        context="{'group_by':'date_order'}" />
                    <filter name="partner_id" string="Customer"
                        icon="terp-stock_symbol-selection" context="{'group_by':'partner_id'}" />
                </group>
            </search>
        </field>
    </record>

    <!--graph view of hotel folio -->
    <record id="view_hotel_folio_graph" model="ir.ui.view">
        <field name="name">view.hotel.folio.graph</field>
        <field name="model">hotel.folio</field>
        <field name="arch" type="xml">
            <graph type="bar">
                <field name="date_order" type="row" />
                <field name="amount_total" type="measure" />
            </graph>
        </field>
    </record>

    <!-- Action for hotel folio -->
    <record id="open_hotel_folio1_form_tree_all" model="ir.actions.act_window">
        <field name="name">Generate Folio</field>
        <field name="res_model">hotel.folio</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form,calendar,graph</field>
        <field name="context">{'folio': True}</field>
    </record>

    <menuitem id="menu_all_folio" name="Folio"
        parent="hotel.hotel_management_menu" sequence="4" />
    <menuitem name="Generate Folio" id="menu_open_hotel_folio1_form_tree_all"
        action="open_hotel_folio1_form_tree_all" sequence="5" parent="menu_all_folio" />

    <!--============ Hotel Service Type ============ -->
    <!-- Form view of hotel service type -->
    <record id="view_hotel_service_type_form" model="ir.ui.view">
        <field name="name">hotel.service_type.form</field>
        <field name="model">hotel.service.type</field>
        <field name="arch" type="xml">
            <form string="Service Type">
                <sheet>
                    <group>
                        <field name="name" string="Service Name" />
                        <field name="service_id" />
                        <field name="child_id" invisible="1" />
                    </group>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Tree view of hotel service type -->
    <record id="view_hotel_service_type_tree" model="ir.ui.view">
        <field name="name">hotel.service_type.tree</field>
        <field name="model">hotel.service.type</field>
        <field name="arch" type="xml">
            <tree string="Service Type">
                <field name="name" />
            </tree>
        </field>
    </record>

    <!-- Action for hotel service type -->
    <record id="open_hotel_service_type_form_tree" model="ir.actions.act_window">
        <field name="name">Service Type</field>
        <field name="res_model">hotel.service.type</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
    </record>
    <menuitem id="menu_hotel_service" name="Services"
        parent="hotel.hotel_configuration_menu" sequence="2" />
    <menuitem name="Service Types" id="menu_open_hotel_service_type_form_tree"
        action="open_hotel_service_type_form_tree" sequence="9"
        parent="hotel.menu_hotel_service" />

    <!--============ Hotel Service ============ -->
    <!-- Form view of hotel service -->
    <record id="view_hotel_services_form" model="ir.ui.view">
        <field name="name">.hotel.services.form</field>
        <field name="model">hotel.services</field>
        <field name="arch" type="xml">
            <form string="Hotel Services">
                <sheet>
                    <h1>
                        <field name="name" select="1" />
                    </h1>
                    <group>
                        <field name="default_code" />
                    </group>
                    <notebook>
                        <page string="Information">
                            <group>
                                <group colspan="4" col="4">
                                    <field name="type" select="2" string="Service Type" />
                                    <field name="categ_id" string="Services Category" />
                                    <field name="product_manager" select="2" string="Service Manager" />
                                    <field name="uom_id" />
                                    <field name="uom_po_id" />
                                </group>
                            </group>
                            <newline />
                            <separator colspan='4' string="Supplier Taxes" />
                            <field name="supplier_taxes_id" colspan="4" nolabel='1'
                                help='List of supplier taxes related to the service provided by hotel.' />
                            <newline />
                            <separator colspan='4' string="Customer Taxes" />
                            <field name="taxes_id" colspan="4" nolabel='1'
                                help='Customer taxes applied on the service.' />
                        </page>
                        <page string="Procurement">
                            <group colspan="4" col="4">
                                <field name="active" select="2" />
                                <field name="list_price" />
                                <field name="cost_method" string="Cost Method" />
                                <field name="sale_ok" select="2" />
                                <field name="standard_price" />
                                <field name="rental" select="2" />
                            </group>
                            <newline />
                            <group>
                                <separator string="Suplliers" />
                                <field name="seller_ids" colspan="4" nolabel="1"
                                    widget="one2many_list" />
                            </group>
                        </page>
                        <page string="Descriptions">
                            <separator string="Description" />
                            <field name="description" colspan="4" nolabel="1" />
                            <separator string="Sale Description" />
                            <field name="description_sale" colspan="4" nolabel="1" />
                            <separator string="Purchase Description" />
                            <field name="description_purchase" colspan="4" nolabel="1" />
                        </page>
                    </notebook>
                </sheet>
            </form>
        </field>
    </record>

    <!-- search view of hotel service -->
    <record id="view_hotel_services_search" model="ir.ui.view">
        <field name="name">hotel.services.search</field>
        <field name="model">hotel.services</field>
        <field name="arch" type="xml">
            <search string="Hotel Services">
                <field name="name" />
                <field name="categ_id" />
                <field name="list_price" string="Service rate" />
                <newline />
                <group expand="0" string="Group By...">
                    <filter name="categ_id" string="Catagory" icon="terp-stock_symbol-selection"
                        domain="[]" context="{'group_by':'categ_id'}" />
                </group>
            </search>
        </field>
    </record>

    <!-- Tree view of hotel service -->
    <record id="view_hotel_services_tree" model="ir.ui.view">
        <field name="name">hotel.services.tree</field>
        <field name="model">hotel.services</field>
        <field name="arch" type="xml">
            <tree string="Hotel Services">
                <field name="name" />
                <field name="categ_id" />
                <field name="list_price" string="Service rate" />
            </tree>
        </field>
    </record>

    <!-- Action for hotel service -->
    <record id="action_hotel_services_form" model="ir.actions.act_window">
        <field name="name">Services</field>
        <field name="res_model">hotel.services</field>
        <field name="view_type">form</field>
        <field name="context">{'default_isservice':1,'default_available_in_pos':0}
        </field>
        <field name="view_mode">tree,form</field>
    </record>

    <menuitem name="Services" id="menu_open_hotel_services_form"
        action="action_hotel_services_form" sequence="8"
        parent="hotel.menu_hotel_service" />

    <!-- Hierarchical Tree view of Service Category -->
    <record id="hotel_service_category_tree_view" model="ir.ui.view">
        <field name="name">hotel.service.type.tree</field>
        <field name="model">hotel.service.type</field>
        <field name="field_parent">child_id</field>
        <field name="arch" type="xml">
            <tree toolbar="True" string="Service Categories">
                <field name="name" />
            </tree>
        </field>
    </record>

    <record id="action_hotel_service" model="ir.actions.act_window">
        <field name="name">Service</field>
        <field name="res_model">hotel.services</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
        <field name="domain">[('isservice', '=', True)]</field>
        <field name="context">{'search_default_product_id':active_id,'default_product_id':active_id}</field>
    </record>

    <!-- Binding Tree Click to Action -->
    <record id="ir_hotel_service_open" model="ir.values">
        <field eval="'tree_but_open'" name="key2" />
        <field eval="'hotel.service.type'" name="model" />
        <field name="name">Services by Category</field>
        <field eval="'ir.actions.act_window,%d'%action_hotel_service"
            name="value" />
    </record>

    <record id="hotel_service_categ_action" model="ir.actions.act_window">
        <field name="name">Services by Category</field>
        <field name="type">ir.actions.act_window</field>
        <field name="res_model">hotel.service.type</field>
        <field name="domain">[('service_id', '=', False)]</field>
        <field name="view_type">tree</field>
        <field name="view_id" ref="hotel_service_category_tree_view" />
    </record>

    <menuitem name="Services by Category" id="menu_hotel_services_categ_action"
        action="hotel_service_categ_action" sequence="10"
        parent="hotel.menu_hotel_service" />

    <!--======== Currency ======== -->
    <!-- Form view of currency exchange -->
    <record id="view_currency_exchange_form" model="ir.ui.view">
        <field name="name">currency.exchange.form</field>
        <field name="model">currency.exchange</field>
        <field name="arch" type="xml">
            <form string=" Currency Exchange">
                <header>
                    <button name="act_cur_done" string="Done" states='draft'
                        icon="fa-check" type="object" class="oe_highlight" />
                    <button name="act_cur_cancel" string="Cancel" states='draft'
                        icon="fa-close" type="object" class="oe_highlight" />
                    <button name="act_cur_cancel_draft" string="Set To Draft"
                        states='cancel' icon="fa-check" type="object" class="oe_highlight" />
                    <button name="%(report_hotel_currency)d" states='done' type="action"
                        string="Print" class="oe_highlight" />
                    <field name="state" widget="statusbar" statusbar_visible="draft,done" />
                </header>
                <sheet>
                    <div class="oe_title ">
                        <label for="name" string="Reg Number" />
                        <h1>
                            <field name="name" />
                        </h1>
                    </div>
                    <separator string="Details" />
                    <newline />
                    <group colspan="2" col="2">
                        <field name="today_date" />
                        <newline />
                    </group>
                    <group colspan="2" col="4">
                        <field name="folio_no" required="1" />
                        <field name="guest_name" required="1" />
                        <field name="room_number" required="1" />
                        <field name="hotel_id" />
                        <field name="type" />
                    </group>
                    <separator string="Currency Exchange" />
                    <newline />
                    <group colspan="2" col="4">
                        <field name="input_curr" required="1" />
                        <field name="in_amount" widget="monetary"
                            options="{'currency_field': 'input_curr'}" />
                        <field name="out_curr" required="1" />
                        <field name="rate" />
                    </group>
                    <group colspan="2" col="2">
                        <field name="out_amount" widget="monetary"
                            options="{'currency_field': 'out_curr'}" readonly="1" />
                        <newline />
                        <field name="tax" />
                    </group>
                    <separator string="Total Amount" />
                    <newline />
                    <h1>
                        <field name="total" widget="monetary" options="{'currency_field': 'out_curr'}"
                            readonly="1" />
                    </h1>
                    <group colspan="2" col="4">
                    </group>
                </sheet>
            </form>
        </field>
    </record>

    <!-- Tree view of currency exchange -->
    <record id="view_currency_exchange_tree" model="ir.ui.view">
        <field name="name">currency.exchange.tree</field>
        <field name="model">currency.exchange</field>
        <field name="arch" type="xml">
            <tree string=" Currency Exchange">
                <field name="name" />
                <field name="today_date" />
                <field name="guest_name" />
                <field name="total" sum="Total" />
            </tree>
        </field>
    </record>

    <!-- Action of currency exchange -->
    <record id="open_currency_exchange_tree" model="ir.actions.act_window">
        <field name="name">Currency Exchange</field>
        <field name="res_model">currency.exchange</field>
        <field name="view_type">form</field>
        <field name="view_mode">tree,form</field>
    </record>

    <menuitem name="Currency Exchange" id="menu_currency_exchange_tree"
        action="open_currency_exchange_tree" sequence="22"
        parent="hotel_configuration_menu" />

</odoo>